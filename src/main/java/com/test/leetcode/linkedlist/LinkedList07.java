package com.test.leetcode.linkedlist;

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
//
//
// 示例 2：
//
//
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 500] 内
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 109
//
// Related Topics 链表 双指针
// 👍 553 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//leetcode submit region end(Prohibit modification and deletion)

public class LinkedList07 {
    public ListNode rotateRight(ListNode head, int k) {
        //边界条件考虑好
        if (head == null || k == 0) return head;
        ListNode tailNode = head;
        int length = 1;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
            length++;
        }
        int newTailNodePosition = length - (k % length);
        //不用旋转的情况
        if (length == k || length == 1 || length == newTailNodePosition) return head;
        ListNode newTail = head;
        while (newTailNodePosition > 1) {
            newTail = newTail.next;
            newTailNodePosition--;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        tailNode.next = head;
        return newHead;
    }

}
