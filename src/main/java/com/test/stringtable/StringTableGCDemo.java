package com.test.stringtable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class StringTableGCDemo {

    // -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) throws IOException {
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
}
