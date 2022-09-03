import org.example.helpers.ListNode;
import org.example.problems.reverse_linked_list.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReverseLinkedListTest {
    private static Stream<Arguments> provideCases() {
        return Stream.of(
            Arguments.of(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))))
            ),
            Arguments.of(
                new ListNode(1, new ListNode(2)),
                new ListNode(2, new ListNode(1))
            )
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(ListNode list, ListNode expected) {
        Solution s = new Solution();
        Assertions.assertTrue(expected.equals(s.reverseList(list)));
    }
}
