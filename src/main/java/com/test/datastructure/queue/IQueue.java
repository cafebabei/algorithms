package com.test.datastructure.queue;

public interface IQueue<T>{

    /**
     * 入队
     */
    void enQueue(T item);

    /**
     * 出队
     */
    T deQueue();

    /**
     * 读取队头元素
     */
    T getHead();

}