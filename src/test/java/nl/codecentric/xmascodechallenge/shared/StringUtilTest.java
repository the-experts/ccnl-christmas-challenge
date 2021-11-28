package nl.codecentric.xmascodechallenge.shared;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
class StringUtilTest {

    @Test
    void toIntegerArray() {
        String input = "\n ,.:!?0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<Integer> test = StringUtil.toAsciiList(input);
        assertThat(test).containsExactly(10, 32, 44, 46, 58, 33, 63, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90);
    }

    @Test
    void toDigitPartsArray() {
        String input = "85903";

        List<Integer> output = StringUtil.toDigitsList(input);
        assertThat(output).containsExactly(8, 5, 9, 0, 3);
    }
}