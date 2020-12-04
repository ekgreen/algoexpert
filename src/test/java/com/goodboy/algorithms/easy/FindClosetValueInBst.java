package com.goodboy.algorithms.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindClosetValueInBst {
    
    @Test
    void test() {
        var root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        var actual = findClosestValueInBst(root, 12);

        Assertions.assertEquals(13, actual);
    }

    public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.

        int closet = Integer.MAX_VALUE;
        int answer = -1;

        while (tree != null){

            var value = Math.abs(target - tree.value);

            if(closet > value) {
                closet = value;
                answer = tree.value;
            }

            if(closet == 0)
                return target;
            else if(tree.value > target){
                tree = tree.left;
            } else {
                tree = tree.right;
            }

        }

        return answer;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
