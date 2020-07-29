package com.none.datastructure.stack;

import java.util.Arrays;

/**
 * 动态扩容栈
 * push pop操作或通过数组拷贝动态调整数组大小，但是耗时与数组大小成正比
 */
public class DynamicCapacityStack<T> implements IStack<T> {

    private T[] items;
    private int size = 0;

    public DynamicCapacityStack(int capacity) {
        assert capacity > 0;
        this.items = (T[]) new Object[capacity];
    }

    @Override
    public void push(T item) {
        //容量已满进行扩容
        if (size == items.length) {
            resize(size * 2);
        }
        items[size++] = item;
    }

    @Override
    public T pop() {
        T item = items[--size];
        //避免对象游离
        items[size] = null;
        if (size > 0 && size <= items.length / 4) resize(items.length / 2);
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

    /**
     * 1.如果newSize小于当前数组长度会导致减容，复制会丢失超过newSize的数据
     * 2.如果newSize大于当前数组长度会扩容
     *
     * @param newSize 新数组长度。
     */
    private void resize(int newSize) {
        items = Arrays.copyOf(items, newSize);
    }
}
