import org.example.problems._01_matrix.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class Problem01MatrixTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[][]{{0,0,0},{0,1,0},{0,0,0}}, new int[][]{{0,0,0},{0,1,0},{0,0,0}}),
            Arguments.of(new int[][]{{0,0,0},{0,1,0},{1,1,1}}, new int[][]{{0,0,0},{0,1,0},{1,2,1}})
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[][] mat, int[][] distances) {
        Solution s = new Solution();
        Assertions.assertTrue(Arrays.deepEquals(distances, s.updateMatrix(mat)));
    }
}
