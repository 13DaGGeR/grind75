import org.example.problems.permutations.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PermutationsTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[]{1,2,3}, new int[][]{{1,2,3},{1,3,2},{2,1,3},{2,3,1},{3,1,2},{3,2,1}}),
            Arguments.of(new int[]{0,1}, new int[][]{{0,1},{1,0}}),
            Arguments.of(new int[]{1}, new int[][]{{1}})
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[] nums, int[][] expected) {
        Solution s = new Solution();
        List<List<Integer>> actual = s.permute(nums);
        int[][] res = new int[actual.size()][nums.length];
        for (int i = 0; i < actual.size(); i++) {
            for (int j = 0; j < actual.get(i).size(); j++) {
                res[i][j] = actual.get(i).get(j);
            }
        }
        Assertions.assertTrue(Arrays.deepEquals(expected, res));
    }
}
