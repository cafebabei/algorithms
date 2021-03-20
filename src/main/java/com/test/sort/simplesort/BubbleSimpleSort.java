package com.test.sort.simplesort;

import com.test.sort.SimpleSortTemplate;

/**
 * 冒泡排序 .
 */
public class BubbleSimpleSort extends SimpleSortTemplate {

    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i]);
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                if (less(a[j + 1], a[j])) exchange(a, j + 1, j);
            }
        }
    }
}
