import org.example.problems._3sum.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Problem3sumTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(
                new int[]{-1, 0, 1, 2, -1, -4},
                new int[][]{{-1, -1, 2}, {-1, 0, 1}}
            ),
            Arguments.of(new int[]{0, 1, 1}, new int[][]{}),
            Arguments.of(new int[]{0, 0, 0}, new int[][]{{0, 0, 0}})
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[] nums, int[][] expected) {
        Solution s = new Solution();

        List<List<Integer>> actual = s.threeSum(nums);

        int[][] converted = actual.stream()
            .map(list -> list.stream().mapToInt(i -> i).toArray())
            .toArray(int[][]::new);

        Assertions.assertTrue(Arrays.deepEquals(expected, converted));
    }
}
