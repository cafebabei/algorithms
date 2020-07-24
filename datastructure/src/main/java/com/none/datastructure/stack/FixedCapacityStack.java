package com.none.datastructure.stack;

import java.lang.reflect.Array;

/**
 * 泛型定容栈简单实现
 */
public class FixedCapacityStack<T> implements IStack<T> {

    private T[] items;
    private int size = 0;

    public FixedCapacityStack(Class<T> type, int capacity) {
        assert capacity > 0;
        this.items = (T[]) Array.newInstance(type, capacity);
    }

    public FixedCapacityStack(int capacity) {
        assert capacity > 0;
        this.items = (T[]) new Object[capacity];
    }

    @Override
    public void push(T item) {
        items[size++] = item;
    }

    @Override
    public T pop() {
        return items[--size];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
