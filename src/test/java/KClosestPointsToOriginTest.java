import org.example.problems.k_closest_points_to_origin.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class KClosestPointsToOriginTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[][]{{1,3},{-2,2}}, 1, new int[][]{{-2,2}}),
            Arguments.of(new int[][]{{3,3}, {5,-1},{-2,4}}, 2, new int[][]{{3,3}, {-2,4}})
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[][] points, int k, int[][] expected) {
        Solution s = new Solution();
        Assertions.assertTrue(Arrays.deepEquals(expected, s.kClosest(points, k)));
    }
}
