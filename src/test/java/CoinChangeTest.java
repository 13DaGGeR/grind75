import org.example.problems.coin_change.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CoinChangeTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[]{1,2,5}, 11, 3),
            Arguments.of(new int[]{2}, 3, -1),
            Arguments.of(new int[]{1}, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[] coins, int amount, int expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.coinChange(coins, amount));
    }
}
