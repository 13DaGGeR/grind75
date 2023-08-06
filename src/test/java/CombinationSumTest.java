import org.example.problems.combination_sum.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CombinationSumTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[]{2, 3, 6, 7}, 7, Arrays.asList(new List[]{Arrays.asList(new Integer[]{3, 2, 2}), Arrays.asList(new Integer[]{7})})),
            Arguments.of(new int[]{2, 3, 5}, 8, Arrays.asList(new List[]{Arrays.asList(new Integer[]{2, 2, 2, 2}), Arrays.asList(new Integer[]{3, 3, 2}), Arrays.asList(new Integer[]{5, 3})})),
            Arguments.of(new int[]{2}, 1, new ArrayList<>())
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[] candidates, int target, List<List<Integer>> expected) {
        Solution s = new Solution();
        List<List<Integer>> result = s.combinationSum(candidates, target);

        Assertions.assertSame(expected.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertTrue(Arrays.equals(expected.get(i).toArray(new Integer[0]), result.get(i).toArray(new Integer[0])));
        }
    }
}
