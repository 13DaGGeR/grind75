import org.example.helpers.TreeNode;
import org.example.problems.maximum_depth_of_binary_tree.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class MaximumDepthOfBinaryTreeTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))), 3),
            Arguments.of(new TreeNode(1, null, new TreeNode(2)), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(TreeNode source, int expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.maxDepth(source));
    }
}
