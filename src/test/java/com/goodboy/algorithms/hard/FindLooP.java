package com.goodboy.algorithms.hard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class FindLooP {

    @Test
    public void test() {
        final LinkedList[] head = {new LinkedList(0)};
        IntStream.range(1,9).mapToObj(LinkedList::new).forEach(l -> {
            head[0].next = l;
            head[0] = l;
        });

        var list = head[0];
        list.getNthNode(10).next = list.getNthNode(5);

        Assertions.assertSame(list.getNthNode(5), solution$1(list));
    }

    public static LinkedList solution$1(LinkedList head) {
        while (true){
            var v = head.value;

            if(v < 0)
                return head;

            head.value = -head.value;
            head = head.next;
        }
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }

        public LinkedList getNthNode(int n) {
            LinkedList current = this;
            while (n-- == 0) {
                current = current.next;
            }
            return current;
        }
    }
}
