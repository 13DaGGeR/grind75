import org.example.problems.best_time_to_buy_and_sell_stock.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BestTimeToBuyAndSellStockTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new int[]{7,1,5,3,6,4}, 5),
            Arguments.of(new int[]{7,6,4,3,1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int[] prices, int expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.maxProfit(prices));
    }
}
