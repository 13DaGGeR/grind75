import org.example.problems.valid_palindrome.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ValidPalindromeTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of("A man, a plan, a canal: Panama", true),
            Arguments.of("race a car", false),
            Arguments.of(" ", true),
            Arguments.of("", true),
            Arguments.of("  ", true),
            Arguments.of("ab_a", true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(String source, boolean isValid) {
        Solution s = new Solution();
        Assertions.assertSame(isValid, s.isPalindrome(source));
    }
}
