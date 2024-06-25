package com.example.utils;

import java.util.Random;

public class WorkWithRandom {
    static Random random = new Random();

    public static int gerRandomIntNumber() {
        return random.nextInt();
    }


}
