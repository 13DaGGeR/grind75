import org.example.helpers.graph.Node;
import org.example.problems.clone_graph.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CloneGraphTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(Node.createFromArray(new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}})),
            Arguments.of(Node.createFromArray(new int[][]{{}})),
            Arguments.of(Node.createFromArray(new int[][]{}))
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(Node node) {
        Solution s = new Solution();
        Assertions.assertEquals(node, s.cloneGraph(node));
        if (node != null) {
            Assertions.assertNotSame(node, s.cloneGraph(node));
        }
    }
}
