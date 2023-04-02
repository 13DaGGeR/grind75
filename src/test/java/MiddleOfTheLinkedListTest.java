import org.example.helpers.ListNode;
import org.example.problems.middle_of_the_linked_list.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MiddleOfTheLinkedListTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(ListNode.createFromArray(new int[]{1, 2, 3, 4, 5, 6}), ListNode.createFromArray(new int[]{4, 5, 6})),
            Arguments.of(ListNode.createFromArray(new int[]{1, 2, 3, 4, 5}), ListNode.createFromArray(new int[]{3, 4, 5}))
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(ListNode head, ListNode expected) {
        Solution s = new Solution();

        Assertions.assertSame(expected.val, s.middleNode(head).val);
        Assertions.assertTrue(expected.equals(s.middleNode(head)));
    }
}
