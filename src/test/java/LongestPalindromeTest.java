import org.example.problems.longest_palindrome.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class LongestPalindromeTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of("abccccdd", 7),
            Arguments.of("a", 1),
            Arguments.of("abc", 1),
            Arguments.of("abcd", 1),
            Arguments.of("aab", 3),
            Arguments.of("aabc", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(String s, int expected) {
        Solution solution = new Solution();
        Assertions.assertSame(expected, solution.longestPalindrome(s));
    }
}
