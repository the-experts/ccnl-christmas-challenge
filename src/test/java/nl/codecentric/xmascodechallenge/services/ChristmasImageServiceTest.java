package nl.codecentric.xmascodechallenge.services;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class ChristmasImageServiceTest {

    @Inject
    ChristmasImageService christmasImageService;

    @Test
    void getChristmasImage() throws IOException {
        byte[] result = christmasImageService.getChristmasImage();
        assertThat(result).hasSize(13210);
    }
}