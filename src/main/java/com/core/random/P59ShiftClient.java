package com.core.random;

import java.util.Arrays;

public class P59ShiftClient {
    public static void main(String[] args) {
        P59Shift random = new P59Shift();
        String[] s = {"a", "b", "c", "d"};
        System.out.println(random.next());
        System.out.println(random.nextDouble(1.0, 5.0));
        System.out.println(Arrays.toString(random.intArray(10, 1, 32)));
        System.out.println(random.nextChoice(s));
        System.out.println(random.nextLetter());
        System.out.println(random.nextSquare(50));
    }
}
