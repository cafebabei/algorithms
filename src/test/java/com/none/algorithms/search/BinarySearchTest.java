package com.none.algorithms.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    @DisplayName("二分查找-在有序数组查找指定元素的位置")
    void binarySearch() {
        int[] a = {1, 2, 3, 4, 5, 6, 8, 9, 11, 13};
        Assertions.assertEquals(BinarySearch.binarySearch(a, 3), 2);

        int[] b = {1, 2, 3, 4, 5};
        Assertions.assertEquals(BinarySearch.binarySearch(b, 3), 2);

        int[] c = {1, 2, 4, 5};
        Assertions.assertEquals(BinarySearch.binarySearch(c, 4), 2);
    }
}