import org.example.problems.maximum_subarray.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class MaximumSubarrayTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6),
            Arguments.of(new int[]{1}, 1),
            Arguments.of(new int[]{5,4,-1,7,8}, 23),
            Arguments.of(new int[]{-2, -1}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[] nums, int expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.maxSubArray(nums));
    }
}
