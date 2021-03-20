package com.test.ds;

/**
 * 数组数据结构 .
 * 插入 删除 查找 遍历
 */
public class ArrayStructure {

    /**
     * array length.
     */
    private int length;
    /**
     * array size.
     */
    private int initSize;
    /**
     * int data array.
     */
    private int[] intArray;

    ArrayStructure() {
        this.initSize = 10;
        this.length = 0;
        intArray = new int[10];
    }

    ArrayStructure(int initSize) {
        this.initSize = initSize;
        this.length = 0;
        intArray = new int[initSize];
    }

    public int getInitSize() {
        return initSize;
    }

    public int[] getIntArray() {
        return intArray;
    }

    public int getLength() {
        return length;
    }

    public int find(int data) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == data) return i;
        }
        return -1;
    }

    public Boolean add(int data) {
        if (length + 1 == initSize) return false;
        intArray[length] = data;
        length++;
        return true;
    }

    public Boolean delete(int data) {
        int k = this.find(data);
        if (k == -1) return false;
        for (int i = k; i < length; i++) {
            intArray[k] = intArray[k + 1];
        }
        length--;
        return true;
    }

    public void show() {
        for (int i = 0; i < length; i++) {
            System.out.print(intArray[i] + "   ");
        }
    }

}
