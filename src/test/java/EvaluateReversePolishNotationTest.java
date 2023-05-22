import org.example.problems.evaluate_reverse_polish_notation.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class EvaluateReversePolishNotationTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new String[]{"2","1","+","3","*"}, 9),
            Arguments.of(new String[]{"4","13","5","/","+"}, 6),
            Arguments.of(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}, 22)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(String[] tokens, int expectedResult) {
        Solution s = new Solution();
        Assertions.assertSame(expectedResult, s.evalRPN(tokens));
    }
}
