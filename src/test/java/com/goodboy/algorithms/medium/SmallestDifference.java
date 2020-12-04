package com.goodboy.algorithms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SmallestDifference {

    @Test
    public void test() {
        int[] expected = {28, 26};

        Assertions.assertArrayEquals(expected, solution$1(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17}));
    }

    public static int[] simple(int[] arrayOne, int[] arrayTwo) {

        var min = Integer.MAX_VALUE;
        var i1 = -1;
        var i2 = -1;

        for (int v1 : arrayOne) {
            for (int v2 : arrayTwo) {
                var abs = Math.abs(v1 - v2);
                if (abs < min) {
                    min = abs;
                    i1 = v1;
                    i2 = v2;
                }
            }
        }

        return new int[]{i1, i2};
    }

    public static int[] solution$1(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int i = 0, j = 0 , hii = arrayOne.length, hij = arrayTwo.length, i1 = -1, i2 = -1, min = Integer.MAX_VALUE;

        while (i < hii && j < hij) {
            int v1 = arrayOne[i];
            int v2 = arrayTwo[j];

            if(v1 < v2)
                i++;
            else
                j++;

            var abs = Math.abs(v1 - v2);
            if (abs < min) {
                min = abs;
                i1 = v1;
                i2 = v2;
            }
        }

        return new int[]{i1, i2};
    }

}
