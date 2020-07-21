package com.none.algorithms.datastructure.stack;

public interface IStack<T> {
    void push(T item);

    T pop();

    boolean isEmpty();

    int size();
}
