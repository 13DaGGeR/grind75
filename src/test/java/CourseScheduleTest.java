import org.example.problems.course_schedule.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CourseScheduleTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(2, new int[][]{{1,0}}, true),
            Arguments.of(2, new int[][]{{1,0}, {0,1}}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(int numCourses, int[][] prerequisites, boolean expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.canFinish(numCourses, prerequisites));
    }
}
