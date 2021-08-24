package com.goodboy.algorithms.very;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

// TODO
public class ApartmentHunting {

    @Test
    void evaluation(){
        List<Map<String, Boolean>> blocks = new ArrayList<>();

        blocks.add(0, new HashMap<>());
        blocks.get(0).put("gym", false);
        blocks.get(0).put("school", true);
        blocks.get(0).put("store", false);

        blocks.add(1, new HashMap<>());
        blocks.get(1).put("gym", true);
        blocks.get(1).put("school", false);
        blocks.get(1).put("store", false);

        blocks.add(2, new HashMap<>());
        blocks.get(2).put("gym", true);
        blocks.get(2).put("school", true);
        blocks.get(2).put("store", false);

        blocks.add(3, new HashMap<>());
        blocks.get(3).put("gym", false);
        blocks.get(3).put("school", true);
        blocks.get(3).put("store", false);

        blocks.add(4, new HashMap<>());
        blocks.get(4).put("gym", false);
        blocks.get(4).put("school", true);
        blocks.get(4).put("store", true);

        String[] reqs = new String[] {"gym", "school", "store"};

        Assertions.assertEquals(3, apartmentHunting(blocks, reqs));
    }


    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        // Write your code here.
        final Set<String> requirements = new HashSet<>(Arrays.asList(reqs));

        int maxIndex = -1;
        int sum = -1;

        final int n = blocks.size();

        // n - iterations
        for (int index = 0; index < n; index++) {
            final Map<String, Boolean> block = blocks.get(index);

            // k - iterations
            int currSum = 0;
            for (Map.Entry<String,Boolean> entry : block.entrySet()) {
                if(requirements.contains(entry.getKey()) && entry.getValue())
                    currSum++;
            }

            if(currSum > sum){
                sum = currSum;
                maxIndex = index;
            }
        }

        return maxIndex + 1;
    }
}
