import org.example.problems.climbing_stairs.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class ClimbingStairsTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(2, 2),
            Arguments.of(3, 3),
            Arguments.of(4, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int n, int expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.climbStairs(n));
    }
}
