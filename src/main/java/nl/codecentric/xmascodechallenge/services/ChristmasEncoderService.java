package nl.codecentric.xmascodechallenge.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.codecentric.xmascodechallenge.shared.CustomColor;
import nl.codecentric.xmascodechallenge.shared.Partition;
import nl.codecentric.xmascodechallenge.shared.StringUtil;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Service responsible for decoding an image back into a text.
 */
@Service
@AllArgsConstructor
@Slf4j
public class ChristmasEncoderService {

    /**
     * Encode each input character into the pixels of the base image from top to bottom, left to right.
     * The encoding is as follows:
     * 1. Convert the character to its ASCII decimal value (k -> 107)
     * 2. Get the digits of the value (107 -> [0, 1, 0, 7]
     * 3. Combine these values to the ARGB channels of the corresponding pixel [255, 100, 100, 100] -> [255, 101, 0, 107]
     * 4. Overwrite the pixel with the new value
     *
     * @param input     the text that will be encoded into the baseImage
     * @param baseImage the image that will be used
     * @return the image with encoded text
     */
    public byte[] encodeChristmas(String input, BufferedImage baseImage) throws IOException {
        Partition<Integer> rows = getInputPartitions(input, baseImage.getWidth());

        for (int y = 0; y < baseImage.getHeight(); y++) {

            if (encodingNeedsTheRow(y, rows.size())) {
                List<Integer> currentRow = rows.get(y);

                for (int x = 0; x < baseImage.getWidth(); x++) {
                    if (encodingNeedsTheColumn(x, currentRow.size())) {
                        CustomColor color = new CustomColor(baseImage.getRGB(x, y));

                        List<Integer> digits = getDigits(currentRow.get(x));

                        int additiveAlpha = swapSignIfLimitReached(digits.get(0), color.getAlphaValue());
                        int additiveRed = swapSignIfLimitReached(digits.get(1), color.getRedValue());
                        int additiveGreen = swapSignIfLimitReached(digits.get(2), color.getGreenValue());
                        int additiveBlue = swapSignIfLimitReached(digits.get(3), color.getBlueValue());

                        color.addColor(additiveAlpha, additiveRed, additiveGreen, additiveBlue);

                        baseImage.setRGB(x, y, color.getColor());
                    }
                }
            }
        }

        return toByteArray(baseImage);
    }

    /**
     * In the default case we ADD encoding to the color channel but if the maximum is breached (255) we subtract instead.
     * This causes no problems since we look at absolute values during decoding.
     * @param additiveValue the value we are going to add
     * @param currentValue the current value
     */
    private int swapSignIfLimitReached(int additiveValue, int currentValue) {
        if (currentValue + additiveValue > 255) {
            return -additiveValue;
        }
        return additiveValue;
    }

    /**
     * Convert an ASCII value to its digits and expand to four values
     * A fourth Digit (alpha channel) needs to be utilized for the 8XXX range ASCII values. (–—‘’‚“”„)
     * @param ASCIIvalue the input ASCII value
     * @return list of digits
     */
    private List<Integer> getDigits(int ASCIIvalue) {
        List<Integer> digits = StringUtil.toDigitsList(String.valueOf(ASCIIvalue));
        while (digits.size() < 4) {
            digits.add(0, 0);
        }
        return digits;
    }

    /**
     * Encoding is done from left to right.
     * For the current row; All pixels where no encoding will occur are skipped
     * @param column the current column
     * @param size the amount of columns of encoding we need for the current row
     * @return whether the current column in the current row will have encoding or not
     */
    private boolean encodingNeedsTheColumn(int column, int size) {
        return column < size;
    }

    /**
     * Encoding is done from top to bottom. All rows where no encoding will occur are skipped entirely
     *
     * @param row  the current row
     * @param size the amount of rows of encoding we need
     * @return whether the current row will have encoding or not
     */
    private boolean encodingNeedsTheRow(int row, int size) {
        return row < size;
    }

    /**
     * Partition the input text into parts the size of the partitionSize
     *
     * @param input         the text to partition
     * @param partitionSize the size of partition
     * @return a wrapped two dimensional array of characters to encode
     */
    private Partition<Integer> getInputPartitions(String input, int partitionSize) {
        List<Integer> asciiCodes = StringUtil.toAsciiList(input);
        return Partition.ofSize(asciiCodes, partitionSize);
    }

    /**
     * Convert the image into a byte array
     */
    private byte[] toByteArray(BufferedImage newBi) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(newBi, "png", baos); //we need to be lossless!
        return baos.toByteArray();
    }
}
