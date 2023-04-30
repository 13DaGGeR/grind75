import org.example.problems.longest_substring_without_repeating_characters.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class LongestSubstringWithoutRepeatingCharactersTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of("abcabcbb", 3),
            Arguments.of("bbbbb", 1),
            Arguments.of("pwwkew", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(String s, int length) {
        Solution solution = new Solution();
        Assertions.assertSame(length, solution.lengthOfLongestSubstring(s));
    }
}
