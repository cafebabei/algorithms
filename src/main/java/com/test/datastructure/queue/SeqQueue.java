package com.test.datastructure.queue;

/**
 * Queue implemented by sequential storage（circular queue）
 *
 * @param <T>
 */
public class SeqQueue<T> implements IQueue<T> {

    private T[] data;

    /**
     * 头尾指针指向同一个节点标识空队列
     * 判断队列满的条件为(rear + 1) % data.length == front 因此需要浪费一个存储空间
     * 可以在定义一个size标识队列的大小或者添加上次入队出队操作的标识tag避免该问题
     */
    private int front = 0;
    private int rear = 0;

    public SeqQueue(int size) {
        data = (T[]) new Object[size];
    }

    /**
     * 当rear等于数组大小时并不一定存满，存在出队的情况，
     * @param item
     * @return
     */
    @Override
    public boolean enQueue(T item) {
        //满
        if ((rear + 1) % data.length == front)
            return false;
        rear = ++rear % data.length;
        data[rear] = item;
        return true;
    }

    @Override
    public T deQueue() {
        //empty queue
        if (front == rear)
            return null;
        front = ++front % data.length;
        T result = data[front];
        data[front] = null;
        return result;
    }

    @Override
    public T getHead() {
        return data[front + 1];
    }
}
