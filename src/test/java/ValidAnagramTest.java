import org.example.problems.valid_anagram.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class ValidAnagramTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of("anagram", "nagaram", true),
            Arguments.of("nagaram", "anagram", true),
            Arguments.of("rat", "car", false),
            Arguments.of("ratt", "raat", false),
            Arguments.of("", "", true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(String s, String t, boolean expected) {
        Solution solution = new Solution();
        Assertions.assertSame(expected, solution.isAnagram(s, t));
    }
}
