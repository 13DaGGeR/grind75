package org.example.problems.reverse_linked_list;

import org.example.helpers.ListNode;
import org.example.problems.SolutionInterface;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Reverse Linked List";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/reverse-linked-list/";
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
