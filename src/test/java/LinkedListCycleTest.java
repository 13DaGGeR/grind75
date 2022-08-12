import org.example.helpers.ListNode;
import org.example.problems.linked_list_cycle.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class LinkedListCycleTest {
    private static Stream<Arguments> provideCases() {
        ListNode tail = new ListNode(-4);
        ListNode second = new ListNode(2, new ListNode(0, tail));
        tail.next = second;
        ListNode cycled1 = new ListNode(3, second);

        ListNode tail2 = new ListNode(2);
        ListNode cycled2 = new ListNode(1, tail2);
        tail2.next = cycled2;
        return Stream.of(
            Arguments.of(cycled1, true),
            Arguments.of(cycled2, true),
            Arguments.of(new ListNode(1), false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCases")
    public void test(ListNode head, boolean expected) {
        Solution s = new Solution();
        Assertions.assertSame(expected, s.hasCycle(head));
    }
}
