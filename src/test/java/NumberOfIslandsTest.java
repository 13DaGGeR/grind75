import org.example.problems.number_of_islands.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class NumberOfIslandsTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
            }, 1),
            Arguments.of(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
            }, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(char[][]grid, int expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.numIslands(grid));
    }
}
