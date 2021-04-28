package com.test.leetcode.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution01Test {

    @Test
    void addTwoNumbers() {
        Solution01.ListNode head = new Solution01.ListNode(9);
        Solution01.ListNode tail = head;
        for (int i = 0; i < 6; i++) {
            Solution01.ListNode newTail = new Solution01.ListNode(9);
            tail.next = newTail;
            tail = newTail;
        }
        Solution01.ListNode head1 = new Solution01.ListNode(9);
        Solution01.ListNode tail1 = head1;
        for (int i = 0; i < 4; i++) {
            Solution01.ListNode newTail = new Solution01.ListNode(9);
            tail1.next = newTail;
            tail1 = newTail;
        }
        Solution01.ListNode result = new Solution01().addTwoNumbers(head1, head);
    }
}