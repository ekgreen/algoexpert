package com.goodboy.algorithms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {
        final List<Integer> result = new ArrayList<>();

        //
        final int rows = array.length;
        final int columns = array[0].length;

        final int length = rows * columns;
        final int direction = 4;
        int level = 0;

        for (int i = 0, j = 0; i < length; j++) {
            switch (j % direction){
                case 0:
                    for (int ll = level; ll < columns - level; ll++, i++)
                        result.add(array[level][ll]);
                    level += 1;
                    break;
                case 1:
                    for (int rd = level; rd <= rows - level; rd++, i++)
                        result.add(array[rd][columns - level]);
                    break;
                case 2:
                    for (int rl = level; rl <= columns - level; rl++, i++)
                        result.add(array[rows - level][columns - rl - 1]);
                    break;
                case 3:
                    for (int lt = level; lt < rows - level; lt++, i++)
                        result.add(array[rows - lt - 1][level - 1]);
                    break;
            }
        }

        return result;
    }

    @Test
    void test() {
        var input =
                new int[][]{
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7},
                };
        var expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
        var actual = spiralTraverse(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test1() {
        var input =
                new int[][]{
                        {1, 2, 3, 4},
                };
        var expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        var actual = spiralTraverse(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test2() {
        var input =
                new int[][]{
                        {1},
                        {1},
                        {1},
                        {1},
                        {1},
                        {1},
                };
        var expected = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1));
        var actual = spiralTraverse(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test3() {
        var input =
                new int[][]{
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7},
                };
        var expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
        var actual = spiralTraverse(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test4() {
        var input =
                new int[][]{
                        {1, 2, 3},
                        {8, 9, 4},
                        {7, 6, 5},
                };
        var expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        var actual = spiralTraverse(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test5() {
        var input =
                new int[][]{
                        {1, 2},
                        {4, 3},
                };
        var expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        var actual = spiralTraverse(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test6(){
        var input =
                new int[][]{
                        {19, 32, 33, 34, 25, 8},
                        {16,15,14,13,12,11},
                        {18,31,36,35,26,9},
                        {1,2,3,4,5,6},
                        {20,21,22,23,24,7},
                        {17,30,29,28,27,10},
                };
        var expected = new ArrayList<>(Arrays.asList(19, 32, 33, 34, 25, 8, 11, 9, 6, 7, 10, 27, 28, 29, 30, 17, 20, 1, 18, 16, 15, 14, 13, 12, 26, 5, 24, 23, 22, 21, 2, 31, 36, 35, 4, 3));
        var actual = spiralTraverse(input);
        Assertions.assertEquals(expected, actual);
    }
}
