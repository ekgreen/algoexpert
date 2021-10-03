package com.goodboy.algorithms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RiverSize {

    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        final var result = new ArrayList<Integer>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                var point = matrix[i][j];

                if (point == 1)
                    result.add(riverSize(matrix, i, j));
            }
        }

        return result;
    }

    public static int riverSize(int[][] matrix, int i, int j) {
        int length = 1;
        matrix[i][j] = -matrix[i][j];

        if (j - 1 >= 0 && matrix[i][j - 1] > 0)
            length += riverSize(matrix, i, j - 1, 4);
        if (j + 1 < matrix[0].length  && matrix[i][j + 1] > 0)
            length += riverSize(matrix, i, j + 1, 2);
        if (i - 1 >= 0  && matrix[i - 1][j] > 0)
            length += riverSize(matrix, i - 1, j, 1);
        if (i + 1 < matrix.length  && matrix[i + 1][j] > 0)
            length += riverSize(matrix, i + 1, j, 3);

        return length;
    }

    /**
     * Recursive algorithm to find length of river
     *
     * @param matrix    program input (river map)
     * @param direction 1 - north, 2 - east, 3 - south, 4 - west
     * @return length of current branch of river
     */
    public static int riverSize(int[][] matrix, int i, int j, int direction) {
        int length = 0;
        switch (direction) {
            case 1:
                for (int k = i; k >= 0; k--) {
                    int value = matrix[k][j];

                    if (value <= 0)
                        return length;
                    else {
                        matrix[k][j] = -value;
                        length += 1;
                        if (j - 1 >= 0 && matrix[k][j - 1] > 0)
                            length += riverSize(matrix, k, j - 1, 4);
                        if (j + 1 < matrix[0].length && matrix[k][j + 1] > 0)
                            length += riverSize(matrix, k, j + 1, 2);
                    }
                }
                break;
            case 2:
                for (int k = j; k < matrix[0].length; k++) {
                    int value = matrix[i][k];

                    if (value <= 0)
                        return length;
                    else {
                        matrix[i][k] = -value;
                        length += 1;
                        if (i - 1 >= 0 && matrix[i - 1][k] > 0)
                            length += riverSize(matrix, i - 1, k, 1);
                        if (i + 1 < matrix.length && matrix[i + 1][k] > 0)
                            length += riverSize(matrix, i + 1, k, 3);
                    }
                }
                break;
            case 3:
                for (int k = i; k < matrix.length; k++) {
                    int value = matrix[k][j];

                    if (value <= 0)
                        return length;
                    else {
                        matrix[k][j] = -value;
                        length += 1;
                        if (j - 1 >= 0 && matrix[k][j - 1] > 0)
                            length += riverSize(matrix, k, j - 1, 4);
                        if (j + 1 < matrix[0].length && matrix[k][j + 1] > 0)
                            length += riverSize(matrix, k, j + 1, 2);
                    }
                }
                break;
            case 4:
                for (int k = j; k >= 0; k--) {
                    int value = matrix[i][k];

                    if (value <= 0)
                        return length;
                    else {
                        matrix[i][k] = -value;
                        length += 1;
                        if (i - 1 >= 0 && matrix[i - 1][k] > 0)
                            length += riverSize(matrix, i - 1, k, 1);
                        if (i + 1 < matrix.length && matrix[i + 1][k] > 0)
                            length += riverSize(matrix, i + 1, k, 3);
                    }
                }
                break;
        }
        return length;
    }

    @Test
    public void testCase1() {
        int[][] input = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };
        int[] expected = {1, 2, 2, 2, 5};
        int[] output = riverSizes(input).stream().sorted().mapToInt(v -> v).toArray();

        Assertions.assertArrayEquals(expected, output);
    }

    @Test
    public void testCase2() {
        int[][] input = {
                {0}
        };
        int[] expected = {};
        int[] output = riverSizes(input).stream().sorted().mapToInt(v -> v).toArray();

        Assertions.assertArrayEquals(expected, output);
    }

    @Test
    public void testCase3() {
        int[][] input = {
                {1}
        };
        int[] expected = {1};
        int[] output = riverSizes(input).stream().sorted().mapToInt(v -> v).toArray();

        Assertions.assertArrayEquals(expected, output);
    }

    @Test
    public void testCase4() {
        int[][] input = {
                {1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0}
        };
        int[] expected = {1, 2, 3};
        int[] output = riverSizes(input).stream().sorted().mapToInt(v -> v).toArray();

        Assertions.assertArrayEquals(expected, output);
    }

    @Test
    public void testCase5() {
        int[][] input = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };
        int[] expected = {49};
        int[] output = riverSizes(input).stream().sorted().mapToInt(v -> v).toArray();

        Assertions.assertArrayEquals(expected, output);
    }
}
