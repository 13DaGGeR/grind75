import org.example.helpers.TreeNode;
import org.example.problems.validate_binary_search_tree.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ValidateBinarySearchTreeTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(new TreeNode(2, new TreeNode(1), new TreeNode(3)), true),
            Arguments.of(new TreeNode(
                5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6))
            ), false),
            Arguments.of(new TreeNode(2, null, new TreeNode(3, new TreeNode(1), null)), false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(TreeNode root, boolean expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.isValidBST(root));
    }
}
