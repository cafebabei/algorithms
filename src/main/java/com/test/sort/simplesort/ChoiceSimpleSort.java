package com.test.sort.simplesort;

import com.test.sort.SimpleSortTemplate;

/**
 * 选择排序 .
 */
public class ChoiceSimpleSort extends SimpleSortTemplate {

    public static void choiceSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (index != i) {
                int tempVal = arr[i];
                arr[i] = arr[index];
                arr[index] = tempVal;
            }
            System.out.println("");
            for (int m = 0; m < arr.length; m++) {
                System.out.print(arr[m]);
            }
        }
    }

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N-1; i++) {
            int min = i;
            for (int j = i+1; j<N; j++){
                if (less(a[j],a[min])) min = j;
            }
            exchange(a,i,min);
        }
    }
}
