package com.goodboy.algorithms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SunsetViews {

    @Test
    public void testCase1() {
        final int[] buildings = new int[]{3, 5, 4, 4, 3, 1, 3, 2};
        var expected = List.of(1, 3, 6, 7);

        var actual = sunsetViews(buildings, "EAST");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        final int[] buildings = new int[]{3, 5, 4, 4, 3, 1, 3, 2};
        var expected = List.of(0, 1);

        var actual = sunsetViews(buildings, "WEST");
        Assertions.assertEquals(expected, actual);
    }

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        // Write your code here.
        final ArrayList<Integer> result = new ArrayList<>();

        int top = 0;
        switch (direction) {
            case "WEST":
                for (int i = 0; i < buildings.length; i++) {
                    top = isViews(result, top, buildings, i);
                }
                break;
            case "EAST":
                for (int i = buildings.length - 1; i >= 0; i--) {
                    top = isViews(result, top, buildings, i);
                }
                Collections.reverse(result);
        }

        return result;
    }

    private int isViews(List<Integer> result, int top, int[] buildings, int i) {
        var building = buildings[i];

        if (top < building)
            result.add(i);

        return Math.max(top, building);
    }
}
