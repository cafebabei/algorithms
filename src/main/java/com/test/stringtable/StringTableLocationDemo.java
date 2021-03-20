package com.test.stringtable;

import java.util.ArrayList;
import java.util.List;

public class StringTableLocationDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            list.add(String.valueOf(i).intern());
            i++;
        }
    }
}
