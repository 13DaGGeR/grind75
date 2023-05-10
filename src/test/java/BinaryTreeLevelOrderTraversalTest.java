import org.example.helpers.TreeNode;
import org.example.problems.binary_tree_level_order_traversal.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

public class BinaryTreeLevelOrderTraversalTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(
                new TreeNode(
                    3,
                    new TreeNode(9),
                    new TreeNode(20, new TreeNode(15), new TreeNode(7))),
                new int[][]{{3},{9,20},{15,7}}
            ),
            Arguments.of(
                new TreeNode(1),
                new int[][]{{1}}
            ),
            Arguments.of(
                null,
                new int[][]{}
            )
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(TreeNode node, int[][] expected) {
        Solution s = new Solution();
        ArrayList<ArrayList<Integer>> expectedList = new ArrayList<>();
        for (int[] ar: expected) {
            ArrayList<Integer> sublist = new ArrayList<>();
            for (int i: ar) {
                sublist.add(i);
            }
            expectedList.add(sublist);
        }
        Assertions.assertEquals(expectedList, s.levelOrder(node));
    }
}
