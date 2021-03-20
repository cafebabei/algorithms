package com.test.stringtable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class StringTableSizeDemo {

    // -XX:StringTableSize
    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        for (int i = 0; i < 2; i++) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/cheney/Desktop/Oxford Dictionary of English 2e.txt"));
            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (Objects.isNull(line)) {
                    break;
                }
                line.intern();
            }
        }
        System.out.println((System.nanoTime() - start) / Math.pow(10, 9));
    }
}