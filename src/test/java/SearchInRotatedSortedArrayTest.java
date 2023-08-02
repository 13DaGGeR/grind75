import org.example.problems.search_in_rotated_sorted_array.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SearchInRotatedSortedArrayTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[]{5, 1, 3}, 1, 1),
            Arguments.of(new int[]{1, 3, 5}, 3, 1),
            Arguments.of(new int[]{1, 3}, 0, -1),
            Arguments.of(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8, 4),
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 2, 6),
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 4, 0),
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
            Arguments.of(new int[]{1}, 0, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[] nums, int target, int expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.search(nums, target));
    }


    private static Stream<Arguments> provideCasesForShiftSearch() {
        return Stream.of(
            Arguments.of(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 4),
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3),
            Arguments.of(new int[]{5, 1, 3}, 0),
            Arguments.of(new int[]{1, 3, 5}, -1)
        );
    }


    @ParameterizedTest
    @MethodSource("provideCasesForShiftSearch")
    public void testShift(int[] nums, int expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.getShiftKey(nums));
    }
}
