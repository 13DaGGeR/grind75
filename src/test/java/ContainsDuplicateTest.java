import org.example.problems.contains_duplicate.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class ContainsDuplicateTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[]{1,2,3,1}, true),
            Arguments.of(new int[]{1,2,3,4}, false),
            Arguments.of(new int[]{1,1,1,3,3,4,3,2,4,2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[] ints, boolean expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.containsDuplicate(ints));
    }
}
