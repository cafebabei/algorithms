package com.test.datastructure.stack;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * 泛型定容栈简单实现
 */
public class FixedCapacityStack<T> implements IStack<T>, Iterable<T> {

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
        T item = items[--size];
        //避免对象游离
        items[size] = null;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public Iterator<T> iterator() {
        return new ReverseItemIterator();
    }

    private class ReverseItemIterator implements Iterator<T> {

        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            i--;
            return pop();
        }
    }
}
