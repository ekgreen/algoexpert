package com.goodboy.algorithms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestPeak {

    public static int longestPeak(int[] array) {
        // Write your code here.
        int longestPeak = -1;
        int peak = 0;
        int currentDirection = -1;

        for (int i = 1; i < array.length; i++) {
            final int direction = Integer.compare(array[i], array[i - 1]);

            if(direction == 0){
                // вход выход на плато
                if(currentDirection == 1){
                    currentDirection = -1;
                }else if(currentDirection == -1){
                    longestPeak = Math.max(longestPeak, peak);
                }
                peak = 0;
            }else {
                // если не плато, то идет либо рост, либо убыль
                if(direction <= currentDirection && peak > 0)
                    peak += 1;
                if(direction == 1 && currentDirection == -1) {
                    longestPeak = Math.max(longestPeak, peak);
                    peak = 2;
                }
                currentDirection = direction;
            }
        }

        return currentDirection == -1 ? Math.max(longestPeak, peak) : longestPeak;
    }

    @Test
    public void testCase1() {
        var input = new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        var expected = 6;

        var actual = longestPeak(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        var input = new int[] {1, 2, 3, 3, 4, 4, 5, 5, 5, 6};
        var expected = 0;

        var actual = longestPeak(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase3() {
        var input = new int[] {6,6,5,5,5,5,5,4,4,4,4,1,1,1,1,1};
        var expected = 0;

        var actual = longestPeak(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase4() {
        var input = new int[] {1,1,1,1,1};
        var expected = 0;

        var actual = longestPeak(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase5() {
        var input = new int[] {1,1,1,1,1,2,1,1,1,1,1};
        var expected = 3;

        var actual = longestPeak(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase6() {
        var input = new int[] {1,2,3,4,5,6,5,4,3,2,1};
        var expected = input.length;

        var actual = longestPeak(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase7() {
        var input = new int[] {1,2,3,4,5,6,5,4,3,2,1,1,1,2,3,4,5,6,7,8,9,10,11,12,13,14,-1,-1,2};
        var expected =15;

        var actual = longestPeak(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase8() {
        var input = new int[] {1,1,1,1,1,2};
        var expected = 0;

        var actual = longestPeak(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase9() {
        var input = new int[] {2,1,1,1,1,1};
        var expected = 0;

        var actual = longestPeak(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase10() {
        var input = new int[] {2,1,1,-1,1,1,2};
        var expected = 0;

        var actual = longestPeak(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase11() {
        var input = new int[] {5,4,3,2,1};
        var expected = 0;

        var actual = longestPeak(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase12() {
        var input = new int[] {1,2,3,4,5};
        var expected = 0;

        var actual = longestPeak(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase13() {
        var input = new int[] {1, 2, 3, 3, 2, 1};
        var expected = 0;

        var actual = longestPeak(input);
        Assertions.assertEquals(expected, actual);
    }
}
