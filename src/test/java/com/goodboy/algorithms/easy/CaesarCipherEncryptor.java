package com.goodboy.algorithms.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaesarCipherEncryptor {

    @Test
    void test() {
        Assertions.assertEquals("zab", caesarCypherEncryptor("xyz", 2));
    }

    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.

        // a = 97, z = 122, c = 26

        key = key % 26;

        char[] array = str.toCharArray();

        for (int i = 0; i < array.length; i++) {
            int value = array[i] + key;
            if(value <= 122)
                array[i] = (char) value;
            else
                array[i] = (char) (96 + value - 122);
        }

        return new String(array);
    }
}
