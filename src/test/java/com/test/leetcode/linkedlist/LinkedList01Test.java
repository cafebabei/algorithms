package com.test.leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedList01Test {

    @Test
    void addTwoNumbers() {
        LinkedList01.ListNode head = new LinkedList01.ListNode(9);
        LinkedList01.ListNode tail = head;
        for (int i = 0; i < 6; i++) {
            LinkedList01.ListNode newTail = new LinkedList01.ListNode(9);
            tail.next = newTail;
            tail = newTail;
        }
        LinkedList01.ListNode head1 = new LinkedList01.ListNode(9);
        LinkedList01.ListNode tail1 = head1;
        for (int i = 0; i < 4; i++) {
            LinkedList01.ListNode newTail = new LinkedList01.ListNode(9);
            tail1.next = newTail;
            tail1 = newTail;
        }

        LinkedList01.ListNode result = new LinkedList01().addTwoNumbers(head1, head);
        String a = new String();
        while (result != null) {
            a = result.val + a;
            result = result.next;
        }
        assertEquals("10099998", a);
    }
}