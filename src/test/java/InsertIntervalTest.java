import org.example.problems.insert_interval.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class InsertIntervalTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}, new int[][]{{1, 5}, {6, 9}}),
            Arguments.of(
                new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                new int[]{4, 8},
                new int[][]{{1, 2}, {3, 10}, {12, 16}}
            )
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[][] intervals, int[] newInterval, int[][] expected) {
        Solution s = new Solution();
        Assertions.assertTrue(Arrays.deepEquals(expected, s.insert(intervals, newInterval)));
    }
}
