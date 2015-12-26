package com.kennycason.starlight.math;

import java.util.Random;

/**
 * Created by kenny on 5/23/15.
 */
public class Dice {

    private static final Random RANDOM = new Random();

    private Dice() {}


    public static int d(final int n) {
        return RANDOM.nextInt(n) + 1;
    }

    public static int d2() {
        return RANDOM.nextBoolean() ? 1 : 2;
    }

    public static int d6() {
        return RANDOM.nextInt(6) + 1;
    }

    public static int d10() {
        return RANDOM.nextInt(10) + 1;
    }

    public static int d100() {
        return RANDOM.nextInt(100) + 1;
    }

    public static int d20() {
        return RANDOM.nextInt(20) + 1;
    }
}
