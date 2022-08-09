import org.example.problems.flood_fill.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FloodFillTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2, new int[][]{{2,2,2},{2,2,0},{2,0,1}}),
            Arguments.of(new int[][]{{0,0,0},{0,0,0}}, 0, 0, 0, new int[][]{{0,0,0},{0,0,0}})
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[][] matrix, int sr, int sc, int color, int[][] expected) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(expected, s.floodFill(matrix, sr, sc, color));
    }
}
