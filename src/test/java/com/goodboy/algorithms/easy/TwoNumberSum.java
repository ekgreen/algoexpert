package com.goodboy.algorithms.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {


    @Test
    void evaluation() {
        final int[] arr = {3, 5, -4, 8, 11, 1, -1, 6};
        final int targetSum = 10;

        Assertions.assertArrayEquals(new int[]{11, -1}, twoNumberSum(arr, targetSum));
    }

    @Test
    void evaluation2() {
        final int[] arr = {3, 5, -4, 8, 11, 1, -1, 6};
        final int targetSum = 10;

        Assertions.assertArrayEquals(new int[]{-1, 11}, twoNumberSum2(arr, targetSum));
    }


    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        final Set<Integer> distinct = new HashSet<>();

        for (int value : array) {
            distinct.add(value);
        }

        for (int value : array) {
            int candidate = targetSum - value;
            if(value != candidate && distinct.contains(candidate))
                return new int[]{value, candidate};
        }

        return new int[0];
    }

    public static int[] twoNumberSum2(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int candidate = array[left] + array[right];
            if(candidate == targetSum)
                return new int[]{array[left], array[right]};
            else if(candidate < targetSum){
                left++;
            }else {
                right--;
            }
        }

        return new int[0];
    }
}
