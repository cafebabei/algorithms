package com.test.datastructure.linearlist.linkedlist;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class SinglyLinkedList {

    private String data;
    private SinglyLinkedList next;

    public SinglyLinkedList(String data) {
        this.data = data;
    }

    /**
     * 带有头节点的按位序插入
     *
     * @param headNode 链表头节点
     * @param bitOrder 位序
     * @param element  插入元素
     * @return
     */
    public Boolean insertWithHeadNode(SinglyLinkedList headNode, int bitOrder, String element) {
        //获取当前位序的前驱节点
        SinglyLinkedList pNode = getElement(headNode, bitOrder - 1);
        //插入新节点
        return insertNextNode(pNode, element);
    }

    /**
     * 不带头节点的按位序插入
     *
     * @param headNode 链表头节点
     * @param bitOrder 位序
     * @param element  插入元素
     * @return
     */
    public Boolean insertWithNoHeadNode(SinglyLinkedList headNode, int bitOrder, String element) {
        if (bitOrder < 1 || Objects.isNull(headNode)) return false;
        if (bitOrder == 1) {
            SinglyLinkedList head = new SinglyLinkedList(element);
            head.next = headNode;
            return true;
        } else {
            SinglyLinkedList pNode = headNode;
            //当前pNode指定第几个节点
            int j = 1;
            //循环找到第bitOrder-1个节点
            while (pNode != null && j < bitOrder - 1) {
                pNode = pNode.next;
                j++;
            }
            if (Objects.isNull(pNode)) return false;
            //插入新节点
            return insertNextNode(pNode, element);
        }
    }

    /**
     * 在指定节点后插入
     *
     * @param pNode
     * @param element
     * @return
     */
    public Boolean insertNextNode(SinglyLinkedList pNode, String element) {
        if (pNode == null) return false;
        SinglyLinkedList newNode = new SinglyLinkedList(element);
        newNode.next = pNode.next;
        pNode.next = newNode;
        return true;
    }

    /**
     * 在指定节点前插入（删除指定节点类似）
     * 1.对于单向链表实现前插操作的话常规情况需要传入链表的头节点，然后依次遍历找到指定节点的父节点然后执行操作，
     * 时间复杂度为O(n)
     * 2.可以通过后插+交换数据的方式实现，时间复杂度为O(1)
     *
     * @param node
     * @param element
     * @return
     */
    public Boolean insertPriorNode(SinglyLinkedList node, String element) {
        if (node == null) return false;
        SinglyLinkedList newNode = new SinglyLinkedList(node.data);
        newNode.next = node.next;
        node.next = newNode;
        node.data = element;
        return true;
    }

    /**
     * 带有头节点的按位删除
     *
     * @param headNode
     * @param bitOrder
     * @return
     */
    public Boolean deleteNode(SinglyLinkedList headNode, int bitOrder) {
        //寻找前驱节点
        SinglyLinkedList pNode = getElement(headNode, bitOrder - 1);
        if (pNode.next == null) return false;
        //删除节点
        pNode.next = pNode.next.next;
        return true;
    }

    /**
     * 删除指定节点
     * 需要当前节点的后继节点不为null,如果当前节点为最后一个节点的话只能从头依次遍历删除
     *
     * @param node
     * @return
     */
    public Boolean deleteNode(SinglyLinkedList node) {
        if (node == null || node.next == null) return false;
        SinglyLinkedList tempNode = node.next;
        node.next = node.next.next;
        node.data = tempNode.data;
        return true;
    }

    /**
     * 带有头节点的按位查找
     *
     * @param headNode
     * @param bitOrder
     * @return
     */
    public SinglyLinkedList getElement(SinglyLinkedList headNode, int bitOrder) {
        if (bitOrder == 0) return headNode;
        if (bitOrder < 0) return null;
        SinglyLinkedList node = headNode;
        int currentPosition = 0;
        while (node != null && currentPosition < bitOrder) {
            node = node.next;
            currentPosition++;
        }
        return node;
    }

    public SinglyLinkedList locateElement(SinglyLinkedList headNode, String elementData) {
        SinglyLinkedList node = headNode;
        while (node != null && !StringUtils.equals(node.data, elementData)) {
            node = node.next;
        }
        return node;
    }
}
