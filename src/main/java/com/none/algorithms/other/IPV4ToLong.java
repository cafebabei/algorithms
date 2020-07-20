package com.none.algorithms.other;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Programming Question:
 * Convert an IPv4 address in the format of null-terminated C string into a 32-bit integer.
 * For example, given an IP address “172.168.5.1”, the output should be a 32-bit integer
 * with “172” as the highest order 8 bit, 168 as the second highest order 8 bit, 5 as the
 * second lowest order 8 bit, and 1 as the lowest order 8 bit. That is,
 * "172.168.5.1" => 2896692481
 * <p>
 * Requirements:
 * 1. You can only iterate the string once.
 * 2. You should handle spaces correctly: a string with spaces between a digit and a dot is
 * a valid input; while a string with spaces between two digits is not.
 * "172[Space].[Space]168.5.1" is a valid input. Should process the output normally.
 * "1[Space]72.168.5.1" is not a valid input. Should report an error.
 * 3. Please provide unit tests.
 *
 * @author chenxiang
 * @version 2019-07-1515:55
 * @since jdk_1.8.0_144
 */
public class IPV4ToLong {

    /**
     * regex.
     */
    public static Predicate<String> predicate = Pattern.compile("\\d{1,3}\\s*(\\.\\s*\\d{1,3}\\s*){3}").asPredicate();

    public static long parseIPV4ToLong(String ipv4Str) {
        Optional.ofNullable(ipv4Str).filter(predicate).orElseThrow(() -> new IllegalArgumentException("Illegal input!"));
        long sum = 0L;
        int shift = 3;
        for (String segmentStr : ipv4Str.split("\\.")) {
            long segment = Long.parseLong(segmentStr.trim());
            sum += segment << ((shift--) * 8);
        }
        return sum;
    }
}

