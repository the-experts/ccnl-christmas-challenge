package nl.codecentric.xmascodechallenge.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.codecentric.xmascodechallenge.shared.CustomColor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Service responsible for decoding an image back into a text.
 */
@Service
@AllArgsConstructor
@Slf4j
public class ChristmasDecoderService {

    /**
     * 1. Iterate over every pixel in the image.
     * 2. Retrieve each pixels ARGB values and compare it with the pixel of the base image
     * 3. Combine the absolute differences back into an ASCII character
     * 4. Append each char back into a string
     *
     * @param input the image to decode
     * @param mask the base image used for encoding
     * @return the decoded text
     */
    public String decodeChristmas(byte[] input, byte[] mask) throws IOException {
        BufferedImage bufferedInput = getBufferedImage(input);
        BufferedImage bufferedMask = getBufferedImage(mask);

        StringBuilder output = new StringBuilder();

        for (int y = 0; y < bufferedInput.getHeight(); y++) {
            for (int x = 0; x < bufferedInput.getWidth(); x++) {
                int inputPixel = bufferedInput.getRGB(x, y);
                int maskPixel = bufferedMask.getRGB(x, y);
                int encodedColorValues = getSummedAbsoluteChannelDifferences(inputPixel, maskPixel);

                if (containsDecodedASCII(encodedColorValues)) {
                    output.append((char) encodedColorValues);
                }
            }
        }

        return output.toString();
    }

    /**
     * Get the absolute differences between the ARGB channels of two color values
     * Since by the encoding definition these difference cannot be bigger than a single digit number they
     * can safely be combined back into a number which represent the decoded decimal ASCII value of this pixel
     * @param inputPixel The to be decoded image
     * @param maskPixel the mask image
     * @return the decoded ASCII value
     */
    private int getSummedAbsoluteChannelDifferences(int inputPixel, int maskPixel) {
        CustomColor inputColor = new CustomColor(inputPixel);
        CustomColor maskColor = new CustomColor(maskPixel);

        int alphaDiff = Math.abs(inputColor.getAlphaValue() - maskColor.getAlphaValue());
        int redDiff = Math.abs(inputColor.getRedValue() - maskColor.getRedValue());
        int greenDiff = Math.abs(inputColor.getGreenValue() - maskColor.getGreenValue());
        int blueDiff = Math.abs(inputColor.getBlueValue() - maskColor.getBlueValue());

        return alphaDiff * 1000 + redDiff * 100 + greenDiff * 10 + blueDiff;
    }

    /**
     * @param ASCIIValue the ARGB value
     * @return whether the number represent an ASCII value or not.
     */
    private boolean containsDecodedASCII(int ASCIIValue) {
        return ASCIIValue != 0;
    }

    /**
     * Turn the image back into an byte array
     */
    private BufferedImage getBufferedImage(byte[] image) throws IOException {
        InputStream is = new ByteArrayInputStream(image);
        return ImageIO.read(is);
    }
}
