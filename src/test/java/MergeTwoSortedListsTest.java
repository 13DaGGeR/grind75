import org.example.helpers.ListNode;
import org.example.problems.merge_two_sorted_lists.Solution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeTwoSortedListsTest {
    @Test
    public void test() {
        ListNode list1 = ListNode.createFromArray(new int[]{1,2,3,4});
        ListNode list2 = ListNode.createFromArray(new int[]{1,3,5,7});
        ListNode expected = ListNode.createFromArray(new int[]{1,1,2,3,3,4,5,7});

        Solution s = new Solution();
        Assertions.assertTrue(s.mergeTwoLists(list1, list2).equals(expected));
    }
}
