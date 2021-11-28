package nl.codecentric.xmascodechallenge.shared;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@UtilityClass
public class StringUtil {

    /**
     * Increase this value for more noticeable encoding changes
     * But will break decoding if not equal to 1
     */
    public final int BASE_MULTIPLIER = 1;
    /**
     * Converts the input string into a list of decimal ASCII values
     * example: "Test" -> [84, 101, 115, 116]
     * @param input the text
     * @return List of integers
     */
    public static List<Integer> toAsciiList(String input) {
        return input.chars().boxed().collect(Collectors.toList());
    }

    /**
     * Converts an integer into its digit parts
     * example: 86950 -> [8, 6, 9, 5, 0]
     * @param input the integer
     * @return List of digits
     */
    public static List<Integer> toDigitsList(String input){
        return Arrays.stream(input
                .split(""))
                .map(s -> Integer.parseInt(s) * BASE_MULTIPLIER)
                .collect(Collectors.toList());
    }
}
