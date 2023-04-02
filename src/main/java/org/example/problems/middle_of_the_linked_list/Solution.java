package org.example.problems.middle_of_the_linked_list;

import org.example.helpers.ListNode;
import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Middle of the Linked List";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/middle-of-the-linked-list/";
    }

    public ListNode middleNode(ListNode head) {
        ListNode result = head;
        ListNode current = head;
        int step = 0;
        while (current != null) {
            current = current.next;

            if (step % 2 == 1) {
                result = result.next;
            }

            step++;
        }

        return result;
    }
}
