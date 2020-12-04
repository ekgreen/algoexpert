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

    public int[] arrayOfProducts(int[] array) {
        // Write your code here.
        var result = new int[array.length];

        int multiplication = 1;

        for (int value : array) {
            multiplication = multiplication * value;
        }

        for (int i = 0; i < array.length; i++) {
            result[i] = multiplication / array[i];
        }

        return result;
    }

    public int[] divisionArrayOfProducts(int[] array) {
        // Write your code here.
        var result = new int[array.length];

        int multiplication = 1;

        for (int value : array) {
            if (value != 0)
                multiplication = multiplication * value;
        }

        for (int i = 0; i < array.length; i++) {
            result[i] = array[i] == 0 ? 0 : multiplication / array[i];
        }

        return result;
    }

}
