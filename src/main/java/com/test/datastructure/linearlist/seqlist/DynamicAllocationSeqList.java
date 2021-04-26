package com.test.datastructure.linearlist.seqlist;

/**
 * 动态分配线性表-可扩容
 */
public class DynamicAllocationSeqList {

    /**
     * array length.
     */
    private int length;
    /**
     * int data array.
     */
    private int[] data;

    DynamicAllocationSeqList(int initSize) {
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
     * 在指定位置插入元素
     *
     * @param bitOrder 元素位序
     * @param element  元素
     * @return
     */
    public Boolean insert(int bitOrder, int element) {
        if (bitOrder > length + 1 || bitOrder < 1)
            throw new IllegalArgumentException();
        if (length == size()) resize();
        for (int i = length; i > bitOrder - 1; i--) {
            data[i] = data[i - 1];
        }
        data[bitOrder - 1] = element;
        length++;
        return true;
    }

    /**
     * 扩容
     */
    private void resize() {
        int newSize = size() + (size() >> 1);
        int[] newData = new int[newSize];
        for (int i = 0; i < size(); i++) {
            newData[i] = data[i];
        }
//        data = Arrays.copyOf(data, newSize);
        data = newData;
    }
}
