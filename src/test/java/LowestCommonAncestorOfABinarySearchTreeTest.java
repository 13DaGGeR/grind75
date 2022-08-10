import org.example.helpers.TreeNode;
import org.example.problems.lowest_common_ancestor_of_a_binary_search_tree.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LowestCommonAncestorOfABinarySearchTreeTest {
    private static Stream<Arguments> provideCases() {
        TreeNode root = new TreeNode(6,
            new TreeNode(
                2,
                new TreeNode(0),
                new TreeNode(4,
                    new TreeNode(3),
                    new TreeNode(5)
                )
            ),
            new TreeNode(
                8,
                new TreeNode(7),
                new TreeNode(9)
            )
        );
        return Stream.of(
            Arguments.of(
                root,
                new TreeNode(2),
                new TreeNode(8),
                new TreeNode(6)
            ),
            Arguments.of(
                root,
                new TreeNode(2),
                new TreeNode(4),
                new TreeNode(2)
            ),
            Arguments.of(
                new TreeNode(2, new TreeNode(1), null),
                new TreeNode(2),
                new TreeNode(1),
                new TreeNode(2)
            )
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(TreeNode root, TreeNode p, TreeNode q, TreeNode expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected.val, s.lowestCommonAncestor(root, p, q).val);
    }
}
