import org.example.helpers.TreeNode;
import org.example.problems.balanced_binary_tree.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class BalancedBinaryTreeTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(
                new TreeNode(
                    3,
                    new TreeNode(9),
                    new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                    )
                ), true),
            Arguments.of(
                new TreeNode(
                    1,
                    new TreeNode(
                        2,
                        new TreeNode(
                            3,
                            new TreeNode(4),
                            new TreeNode(4)
                        ),
                        new TreeNode(3)
                    ),
                    new TreeNode(2)
                ), false),
            Arguments.of(
                new TreeNode(
                    1,
                    new TreeNode(
                        2,
                        new TreeNode(
                            3,
                            new TreeNode(4),
                            null
                        ),
                        null
                    ),
                    new TreeNode(
                        2,
                        null,
                        new TreeNode(
                            3,
                            null,
                            new TreeNode(4)
                        )
                    )
                ),
                false
            )
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(TreeNode root, boolean expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.isBalanced(root));
    }
}
