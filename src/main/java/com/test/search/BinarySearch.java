package com.test.search;

public class BinarySearch {

    /**
     * 二分查找算法
     *
     * @param a   有序数组
     * @param key 需要查找的键值
     * @return key在a中的位置
     */
    public static int binarySearch(int[] a, int key) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (a[mid] == key) return mid;
            if (a[mid] > key) end = mid - 1;
            if (a[mid] < key) start = mid + 1;
        }
        return -1;
    }
}
