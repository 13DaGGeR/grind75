package org.example.problems.linked_list_cycle;

import org.example.helpers.ListNode;
import org.example.problems.SolutionInterface;

import java.util.HashSet;
import java.util.Set;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Linked List Cycle";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/linked-list-cycle/";
    }

    /**
     * Fast solution
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * Readable solution
     */
    @SuppressWarnings("unused")
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }

        return false;
    }
}
