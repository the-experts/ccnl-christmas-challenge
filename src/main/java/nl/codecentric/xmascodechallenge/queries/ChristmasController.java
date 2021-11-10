package nl.codecentric.xmascodechallenge.queries;

import nl.codecentric.xmascodechallenge.services.ChristmasImageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.io.IOException;

@RestController
@RequestMapping("/xmas")
public class ChristmasController {

    private final ChristmasImageService christmasImageService;

    @Inject
    public ChristmasController(ChristmasImageService christmasImageService) {
        this.christmasImageService = christmasImageService;
    }


    @GetMapping(value = "/vibesAtCCNL", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getTheVibes() throws IOException {
        return christmasImageService.getChristmasImage();
    }
}
