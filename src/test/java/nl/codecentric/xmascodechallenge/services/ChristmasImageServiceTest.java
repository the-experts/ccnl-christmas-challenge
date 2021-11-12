package nl.codecentric.xmascodechallenge.services;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@QuarkusTest
class ChristmasImageServiceTest {

    @Inject
    ChristmasImageService christmasImageService;

    @Test
    void getChristmasImage() throws IOException {
        try (InputStream in = new FileInputStream("src/test/resources/testChristmasImage.jpg")) {
            byte[] expected = in.readAllBytes();
            in.close();
            byte[] result = christmasImageService.getChristmasImage();
            Assertions.assertArrayEquals(expected, result);
        }
    }
}