package com.test.datastructure.queue;

public class LinkedQueue<T> implements IQueue<T> {

    private LinkedNode<T> front;
    private LinkedNode<T> rear;

    public LinkedQueue() {
        //Initialize the head node
        front = new LinkedNode<>();
    }

    @Override
    public boolean enQueue(T item) {
        if (rear == null) {
            rear = new LinkedNode(item);
            front.next = rear;
        } else {
            LinkedNode newRear = new LinkedNode(item);
            rear.next = newRear;
            rear = newRear;
        }
        return true;
    }

    @Override
    public T deQueue() {
        LinkedNode firstNode = front.next;
        if (firstNode == null) return null;
        front.next = firstNode.next;
        return (T) firstNode.data;
    }

    @Override
    public T getHead() {
        LinkedNode firstNode = front.next;
        if (firstNode == null) return null;
        return (T) firstNode.data;
    }


    public class LinkedNode<T> {

        public LinkedNode() {

        }

        public LinkedNode(T t) {
            data = t;
        }

        public T data;
        public LinkedNode next;
    }
}
