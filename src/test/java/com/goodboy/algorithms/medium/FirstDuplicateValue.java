package com.goodboy.algorithms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstDuplicateValue {

    @Test
    void testCase1() {
        var input = new int[]{2, 1, 5, 2, 3, 3, 4};
        var expected = 2;

        int actual = firstDuplicateValue(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testCase2() {
        var input = new int[]{2, 1, 5, 3, 3, 2, 4};
        var expected = 3;

        int actual = firstDuplicateValue(input);
        Assertions.assertEquals(expected, actual);
    }

    public int firstDuplicateValue(int[] array) {
        // Write your code here.
        for (int i = 0; i < array.length; i++) {
            final int v1 = Math.abs(array[i]);
            final int v2 = array[v1 - 1];

            if (v2 < 0)
                return v1;
            else
                array[v1 - 1] = -v2;
        }

        return -1;
    }

}
