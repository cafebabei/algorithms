package com.test.leetcode.linkedlist;

//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 堆 链表 分治算法
// 👍 1279 👎 0


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
class LinkedList04 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoList(result, lists[i]);
        }
        return result;
    }

    /**
     * 分治
     * @param lists
     * @return
     */
    public ListNode mergeKLists01(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start < end) return null;
        int mid = (start + end) >> 1;
        return mergeTwoList(merge(lists, start, mid), merge(lists, mid + 1, end));
    }

    private ListNode mergeTwoList(ListNode list, ListNode list1) {
        if (list == null) {
            return list1;
        } else if (list1 == null) {
            return list;
        } else if (list.val <= list1.val) {
            list.next = mergeTwoList(list.next, list1);
            return list;
        } else {
            list1.next = mergeTwoList(list1.next, list);
            return list1;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

