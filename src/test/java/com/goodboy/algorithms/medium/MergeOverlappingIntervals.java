package com.goodboy.algorithms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {

    @Test
    public void testCase1() {
        var intervals =
                new int[][]{
                        {1, 2},
                        {3, 5},
                        {4, 7},
                        {6, 8},
                        {9, 10}
                };
        var expected =
                new int[][]{
                        {1, 2},
                        {3, 8},
                        {9, 10}
                };
        int[][] actual = mergeOverlappingIntervals(intervals);

        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testCase2() {
        var intervals =
                new int[][]{
                        {1, 2},
                        {3, 5},
                        {4, 6},
                        {6, 8},
                        {9, 10},
                        {11,12},
                        {12,14},
                };
        var expected =
                new int[][]{
                        {1, 2},
                        {3, 8},
                        {9, 10},
                        {11, 14}
                };
        int[][] actual = mergeOverlappingIntervals(intervals);

        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testCase3() {
        var intervals =
                new int[][]{
                        {1, 2},
                        {3, 5},
                        {6, 8},
                        {9, 10}
                };
        var expected =
                new int[][]{
                        {1, 2},
                        {3, 5},
                        {6, 8},
                        {9, 10}
                };
        int[][] actual = mergeOverlappingIntervals(intervals);

        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testCase5() {
        var intervals =
                new int[][]{
                        {1, 22},
                        {-20, 30}
                };
        var expected =
                new int[][]{
                        {-20, 30},
                };
        int[][] actual = mergeOverlappingIntervals(intervals);

        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void testCase4() {
        var intervals =
                new int[][]{
                        {-100, -50},
                        {-51, 10},
                        {10, 11}
                };
        var expected =
                new int[][]{
                        {-100, 11}
                };
        int[][] actual = mergeOverlappingIntervals(intervals);

        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], actual[i]);
        }
    }

    private int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        final List<int[]> result = new ArrayList<>();

        var lane = Arrays.stream(intervals).map(arr -> arr[0])
                .sorted()
                .toArray(Integer[]::new);

        var closes = Arrays.stream(intervals).map(arr -> arr[1])
                .sorted()
                .toArray(Integer[]::new);

        var opened = 0;
        var value = 0;

        for (int i = 0, j = 0; i < closes.length;) {
            if(opened == 0) {
                value = lane[j++];
                opened += 1;
            }else {
                var close = closes[i];

                if(j < lane.length && lane[j] <= close){
                    j += 1;
                    opened += 1;
                }else {
                    i += 1;
                    opened -= 1;

                    if(opened == 0)
                        result.add(new int[]{value, close});
                }
            }
        }

        return result.toArray(int[][]::new);
    }
}
