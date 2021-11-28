package nl.codecentric.xmascodechallenge.queries;

import lombok.AllArgsConstructor;
import nl.codecentric.xmascodechallenge.services.ChristmasDecoderService;
import nl.codecentric.xmascodechallenge.services.ChristmasEncoderService;
import nl.codecentric.xmascodechallenge.services.ChristmasImageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/xmas")
@AllArgsConstructor
public class ChristmasController {

    private final ChristmasImageService christmasImageService;
    private final ChristmasEncoderService christmasEncoder;
    private final ChristmasDecoderService christmasDecoder;

    @GetMapping(value = "/vibesAtCCNL", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getTheVibes() throws IOException {
        return christmasImageService.getChristmasImage();
    }

    @PostMapping(value = "encode", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getEncodedImage(@RequestBody String input) throws IOException {
        if (input.length() > 1000000) {
            throw new RuntimeException("Message is too long!");
        }

        return christmasEncoder.encodeChristmas(input, christmasImageService.createImage());
    }

    @PostMapping(value = "decode", consumes = MediaType.IMAGE_PNG_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getDecodedImage(@RequestBody byte[] input) throws IOException {
        return christmasDecoder.decodeChristmas(input, christmasImageService.getChristmasImage());
    }
}
