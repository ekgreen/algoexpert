package com.goodboy.algorithms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOfProducts {

    @Test
    void test() {
        var input = new int[]{5, 1, 4, 2};
        var expected = new int[]{8, 40, 10, 20};
        int[] actual = arrayOfProducts(input);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testCase2() {
        var input = new int[]{0,5, 1, 4, 2};
        var expected = new int[]{40,0,0,0,0};
        int[] actual = arrayOfProducts(input);
        Assertions.assertArrayEquals(expected, actual);
    }

    public int[] arrayOfProducts(int[] array) {
        // Write your code here.
        var result = new int[array.length];

        int zero_count = 0;
        int multiplication = 1;



        for (int value : array) {
            if(value == 0)
                zero_count += 1;
            else
                multiplication = multiplication * value;
        }

        if(zero_count < 2) {
            int k = zero_count == 1 ? 0 : 1;

            for (int i = 0; i < array.length; i++) {
                int value = array[i];

                if (value != 0)
                    result[i] = k * multiplication / array[i];
                else
                    result[i] = multiplication;
            }
        }

        return result;
    }

}
