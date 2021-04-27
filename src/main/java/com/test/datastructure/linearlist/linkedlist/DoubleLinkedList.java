package com.test.datastructure.linearlist.linkedlist;

public class DoubleLinkedList {

    /**
     * 数据域
     */
    private String data;

    /**
     * 前驱节点
     */
    private DoubleLinkedList prior;

    /**
     * 后继节点
     */
    private DoubleLinkedList next;

    public Boolean insertNextNode(DoubleLinkedList p, DoubleLinkedList n) {
        if (p == null || n == null) return false;
        n.next = p.next;
        if (p.next != null) p.next.prior = n;
        p.next = n;
        n.prior = p;
        return true;
    }

    public Boolean deleteNode(DoubleLinkedList node) {
        if (node == null) return false;
        node.prior.next = node.next;
        if (node.next != null) node.next.prior = node.prior;
        return true;
    }
}
