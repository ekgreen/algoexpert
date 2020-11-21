package com.goodboy.algorithms.easy;

import java.util.List;

public class ValidateSubsequence {

    public static void main(String[] args) {
        List<Integer> array = List.of(5,1,22,25,6,-1,7,10);
        List<Integer> sequence = List.of(5,1,22,25,6,-1,7,10);
        System.out.println(isValidSubsequence(array, sequence));
    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.

        if(array == null || sequence == null)
            return false;

        final int array_size = array.size();
        final int sequence_size = sequence.size();

        if(array_size < sequence_size)
            return false;

        int i = 0, j = 0;
        int value;
        for (;i < array_size; i++) {
            if(array.get(i) == (value = sequence.get(j)) && ++j == sequence_size)
                return true;
        }

        return false;
    }
}
