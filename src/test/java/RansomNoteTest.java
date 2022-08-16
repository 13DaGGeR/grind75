import org.example.problems.ransom_note.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class RansomNoteTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of("a", "b", false),
            Arguments.of("aa", "ab", false),
            Arguments.of("aa", "aab", true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(String ransomNote, String magazine, boolean expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.canConstruct(ransomNote, magazine));
    }
}
