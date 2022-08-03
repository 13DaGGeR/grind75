import org.example.helpers.TreeNode;
import org.example.problems.invert_binary_tree.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvertBinaryTreeTest {
    @Test
    public void test() {
        TreeNode tree = new TreeNode(
            4,
            new TreeNode(
                2,
                new TreeNode(1),
                new TreeNode(3)
            ),
            new TreeNode(
                7,
                new TreeNode(6),
                new TreeNode(9)
            )
        );
        TreeNode expected = new TreeNode(
            4,
            new TreeNode(
                7,
                new TreeNode(9),
                new TreeNode(6)
            ),
            new TreeNode(
                2,
                new TreeNode(3),
                new TreeNode(1)
            )
        );
        Solution s = new Solution();
        Assertions.assertTrue(s.invertTree(tree).equals(expected));
    }
}
