package com.goodboy.algorithms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MonotonicArray {

    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        if(array.length <= 2)
            return true;

        int grow = 0;
        int val = array[0];
        for (int i = 1; i < array.length; i++) {
            var next = array[i];

            if(grow != 0 && (next - val) * grow < 0)
                return false;

            if(next != val)
                grow = (next - val) > 0 ? 1 : -1;

            val = next;
        }

        return true;
    }

    @Test
    void test() {
        var input = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        var expected = true;

        var actual = isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test1() {
        var input = new int[]{1};
        var expected = true;

        var actual = isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test2() {
        var input = new int[]{0, 0, 0, 0 , 0};
        var expected = true;

        var actual = isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test3() {
        var input = new int[]{-5, -3, 0, 3 , 6};
        var expected = true;

        var actual = isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test4() {
        var input = new int[]{-5, -3, 10, 3 , 6};
        var expected = false;

        var actual = isMonotonic(input);
        Assertions.assertEquals(expected, actual);
    }
}
