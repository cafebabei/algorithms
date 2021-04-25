package com.test.datastructure.linearlist;

/**
 * 静态分配线性表.
 */
public class StaticAllocationLinearList {

    /**
     * array length.
     */
    private int length;
    /**
     * int data array.
     */
    private int[] data;

    StaticAllocationLinearList(int initSize) {
        this.length = 0;
        data = new int[initSize];
    }

    public int size() {
        return data.length;
    }

    public int length() {
        return length;
    }

    /**
     * 定位元素在线性表中的位序
     *
     * @param element 元素值
     * @return 元素位序
     */
    public int locateElement(int element) {
        for (int i = 0; i < this.length; i++) {
            if (this.data[i] == element) return i + 1;
        }
        return 0;
    }

    /**
     * 返回线性表中bitOrder位序上的值
     *
     * @param bitOrder 元素位序
     * @return
     */
    public int getElement(int bitOrder) {
        if (bitOrder > 0 || bitOrder <= this.length) return data[bitOrder - 1];
        else throw new IllegalArgumentException();
    }

    /**
     * 在指定位置插入元素
     *
     * @param bitOrder
     * @param element
     * @return
     */
    public Boolean insert(int bitOrder, int element) {
        if (length == size() || bitOrder > length + 1 || bitOrder < 1) return false;
        for (int i = length; i > bitOrder - 1; i--) {
            data[i] = data[i - 1];
        }
        data[bitOrder - 1] = element;
        length++;
        return true;
    }

    /**
     * 删除指定位置的元素
     *
     * @param bitOrder
     * @return
     */
    public Boolean delete(int bitOrder) {
        if (bitOrder > length || bitOrder < 1) return false;
        for (int i = bitOrder - 1; i < length - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[length - 1] = 0;
        length--;
        return true;
    }
}
