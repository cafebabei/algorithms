package com.test.sort.simplesort;

import com.test.sort.SimpleSortTemplate;

/**
 * 直接插入排序 .
 */
public class InsertSimpleSort extends SimpleSortTemplate {


    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
            System.out.println("");
            for (int m = 0; m < arr.length; m++) {
                System.out.print(arr[m]);
            }
        }

    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            Comparable temp = a[i];
            int j = i;
            while (j > 0 && less(temp, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = temp;
        }
    }
}
