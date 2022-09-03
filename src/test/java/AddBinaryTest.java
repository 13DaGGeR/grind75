import org.example.problems.add_binary.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class AddBinaryTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of("11", "1", "100"),
            Arguments.of("1010", "1011", "10101")
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(String a, String b, String expected) {
        Solution s = new Solution();
        Assertions.assertEquals(expected, s.addBinary(a, b));
    }
}
