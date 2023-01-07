import org.example.helpers.TreeNode;
import org.example.problems.diameter_of_binary_tree.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class DiameterOfBinaryTreeTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(
                new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3)),
                3
            ),
            Arguments.of(
                new TreeNode(1, new TreeNode(2), null),
                1
            ),
            Arguments.of(
                new TreeNode(
                    1,
                    new TreeNode(
                        2,
                        new TreeNode(
                            3,
                            new TreeNode(
                                4,
                                new TreeNode(5),
                                null
                            ),
                            null),
                        new TreeNode(
                            6,
                            null,
                            new TreeNode(
                                7,
                                new TreeNode(8),
                                null
                            )
                        )
                    ),
                    null),
                6
            )
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(TreeNode root, int diameter) {
        Solution s = new Solution();
        Assertions.assertSame(diameter, s.diameterOfBinaryTree(root));
    }
}
