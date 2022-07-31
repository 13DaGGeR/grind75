package org.example.helpers;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createFromArray(int[] values) {
        if (values.length < 1) {
            throw new IllegalArgumentException("At least one number needed");
        }

        ListNode first = new ListNode(values[0]);
        ListNode current = first;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return first;
    }

    public boolean equals(ListNode obj) {
        if (obj == null) {
            return false;
        }

        if (obj.next != null && next == null) {
            return false;
        }
        if (obj.next == null && next != null) {
            return false;
        }

        return val == obj.val && (obj.next == null || next.equals(obj.next));
    }
}
