import org.example.problems.valid_parentheses.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ValidParenthesesTest {

    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of("()", true),
            Arguments.of("()[]{}", true),
            Arguments.of("(]", false),
            Arguments.of("([)]", false),
            Arguments.of("([]){}", true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(String s, boolean expected) {
        Solution solution = new Solution();
        Assertions.assertSame(expected, solution.isValid(s));
    }
}
