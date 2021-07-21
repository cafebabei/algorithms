package com.test.datastructure.queue;

public interface IQueue<T extends Object>{

    /**
     * 入队
     */
    boolean enQueue(T item);

    /**
     * 出队
     */
    T deQueue();

    /**
     * 读取队头元素
     */
    T getHead();

}