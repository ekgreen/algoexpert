package com.goodboy.algorithms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ThreeNumberSum {

    @Test
    void evaluation() {
        final int[] arr = {12, 3, 1, 2, -6, 5, -8, 6};
        final int targetSum = 0;

        final List<Integer[]> actual = threeNumberSum(arr, targetSum);

        List<Integer[]> expected = new ArrayList<>();
        expected.add(new Integer[] {3, 5, -8});
        expected.add(new Integer[] {1, -6, 5});
        expected.add(new Integer[] {2, -8, 6});

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertArrayEquals(expected.get(i), actual.get(i));
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        final ArrayList<Integer[]> result = new ArrayList<>();

        final Set<Integer> distinct = new HashSet<>();

        for (int value : array) {
            distinct.add(value);
        }

        for (int v = 0; v < array.length; v++) {
            int c1 = array[v];
            int c2c3 = targetSum - c1;

            for (int v2 = v + 1; v2 < array.length; v2++) {
                int c2 = array[v2];
                int c3 = c2c3 - c2;

                if (c1 != c2 && c2 != c3 && c1 != c3 && distinct.contains(c3)) {
                    result.add(new Integer[]{c1, c2, c3});
                }
            }
        }


        return result;
    }
}
