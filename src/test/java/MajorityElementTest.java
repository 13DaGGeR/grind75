import org.example.problems.majority_element.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class MajorityElementTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[]{3, 2, 3}, 3),
            Arguments.of(new int[]{2, 2, 1, 1, 1, 2, 2}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[] nums, int expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.majorityElement(nums));
    }
}
