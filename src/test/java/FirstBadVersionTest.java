import org.example.problems.first_bad_version.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class FirstBadVersionTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(5, 4),
            Arguments.of(1, 1),
            Arguments.of(5, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int numberOfVersions, int badVersion) {
        Solution s = new Solution((Integer version) -> version >= badVersion);
        Assertions.assertSame(badVersion, s.firstBadVersion(numberOfVersions));
    }
}
