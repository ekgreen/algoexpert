package com.goodboy.algorithms.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class TaskAssignment {

    public ArrayList<ArrayList<Integer>> taskAssignment(int k, List<Integer> tasks) {
        // Write your code here.
        final ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        final Entry[] values = IntStream.range(0, tasks.size())
                .mapToObj(i -> new Entry(i, tasks.get(i)))
                .sorted(Comparator.comparing(Entry::getValue))
                .toArray(Entry[]::new);


        // 2k
        for (int i = 0; i < values.length / 2; i++) {
            var taskOwnedByWorker = new ArrayList<>(Arrays.asList(values[i].index, values[values.length - 1 - i].index));

            result.add(taskOwnedByWorker);
        }

        return result;
    }

    public static class Entry{
        int index;
        int value;
        public Entry(int index, int value) {
            this.index = index;
            this.value = value;
        }
        public int getIndex() { return index; }
        public int getValue() { return value; }
    }

    @Test
    public void testCase1() {
        var k = 3;
        var tasks = List.of(1, 3, 5, 3, 1, 4);

        var expected = List.of(
                List.of(4, 2),
                List.of(0, 5),
                List.of(3, 1)
        );

        var actual = taskAssignment(k, tasks);
        Assertions.assertEquals(expected, actual);
    }
}
