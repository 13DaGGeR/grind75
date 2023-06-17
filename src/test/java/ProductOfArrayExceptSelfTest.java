import org.example.problems.product_of_array_except_self.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ProductOfArrayExceptSelfTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[]{1,2,3,4}, new int[]{24,12,8,6}),
            Arguments.of(new int[]{-1,1,0,-3,3}, new int[]{0,0,9,0,0})
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[] nums, int[] expected) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(expected, s.productExceptSelf(nums));
    }
}
