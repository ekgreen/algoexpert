package com.goodboy.algorithms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    @Test
    public void test() {
        var expected = List.of(4, 1, 3, 2, 2, 2, 2, 2);

        Assertions.assertIterableEquals(expected, solution$1(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2), 2));
    }

    public static List<Integer> solution$1(List<Integer> array, int toMove) {
        var length = array.size();

        for (int i = 0, j = length -1; i < length && i < j;) {
            var l = array.get(j);

            if(l == toMove)
                j--;
            else {
                var v = array.get(i);

                if(v == toMove){
                    array.set(j, toMove);
                    array.set(i, l);
                }

                i++;
            }
        }

        return array;
    }
}