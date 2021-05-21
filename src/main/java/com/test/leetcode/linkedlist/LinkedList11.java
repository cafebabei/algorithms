package com.test.leetcode.linkedlist;

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
//
//
// 示例 2：
//
//
//输入：head = [5], left = 1, right = 1
//输出：[5]
//
//
//
//
// 提示：
//
//
// 链表中节点数目为 n
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
//
//
//
//
// 进阶： 你可以使用一趟扫描完成反转吗？
// Related Topics 链表
// 👍 908 👎 0


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
class LinkedList11 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(0, head);
        ListNode curLeft = newHead;
        ListNode curRight = newHead;
        //计算反转链表起始位置
        for (int i = 0; i < right; i++) {
            if (i == left - 1) curLeft = curRight;
            curRight = curRight.next;
        }
        //原链表
        ListNode leftNode = curLeft.next;
        ListNode tailNode = leftNode;
        curLeft.next = null;
        ListNode rightNode = curRight.next;
        curRight.next = null;
        //头插反转
        while (leftNode != null) {
            ListNode nextLeftNode = leftNode.next;
            ListNode next = curLeft.next;
            curLeft.next = leftNode;
            leftNode.next = next;
            leftNode = nextLeftNode;
        }
        tailNode.next = rightNode;
        return newHead.next;
    }


    public static void main(String[] args) {
        reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

