import org.example.problems.binary_search.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class BinarySearchTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[]{-1,0,3,5,9,12}, 9, 4),
            Arguments.of(new int[]{-1,0,3,5,9,12}, 2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[] nums, int target, int expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.search(nums, target));
    }
}
