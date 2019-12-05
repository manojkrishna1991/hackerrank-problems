package com.manoj.hackerrank.birthday.chocolate;

/**
 * Hacker Rank BirthDay Problem
 */

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Hacker Rank Birthday Problem
 */
public class BirthDayChocolate {

    static int birthday(List<Integer> s, int d, int m) {
        if (s.size() == 1) {
            if (s.get(0) == d) {
                return 1;
            } else {
                return 0;
            }
        }
        return IntStream.range(0, s.size() - 1).mapToObj(iteration -> {
            int result = 0;
            for (int chocolateIndex = 0; chocolateIndex < m; chocolateIndex = chocolateIndex + 1) {
                int nextElement = chocolateIndex + iteration;
                if (nextElement <= s.size() - 1) {
                    result = result + s.get(nextElement);
                }
            }
            if (result == d) {
                return 1;
            } else {
                return 0;
            }

        }).mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) throws IOException {
        List inputChocolates = Arrays.asList(1, 2, 1, 3, 2);
        int result = birthday(inputChocolates, 3, 2);
    }
}
