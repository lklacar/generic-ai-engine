package com.lukaklacar.aiengine.util;

import java.util.List;
import java.util.Random;

public class RandomUtil {

    private static Random random = new Random();

    public static <T> T choose(List<T> items) {
        try {
            return items.get(random.nextInt(items.size()));
        } catch (Exception ex) {
            return null;
        }
    }

    public static int randInt(int max) {
        return random.nextInt(max);
    }
}
