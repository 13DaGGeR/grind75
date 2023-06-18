import org.example.problems.rotting_oranges.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RottingOrangesTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[][]{{2,1,1},{1,1,0},{0,1,1}}, 4),
            Arguments.of(new int[][]{{2,1,1},{0,1,1},{1,0,1}}, -1),
            Arguments.of(new int[][]{{0,2}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[][] grid, int expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.orangesRotting(grid));
    }
}
