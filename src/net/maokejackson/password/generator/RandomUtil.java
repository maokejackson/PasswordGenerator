package net.maokejackson.password.generator;

import java.util.Random;

/**
 * Created by Maoke Jackson on 19/10/2014.
 */
public final class RandomUtil {

    static final Random rand = new Random();

    private RandomUtil() {
        throw new Error(getClass() + " contains static methods only.");
    }

    public static int randomInt(int min, int max) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return rand.nextInt((max - min) + 1) + min;
    }

    public static String randomSwap(String text) {
        char[] array = text.toCharArray();
        final int length = array.length;

        for (int i = 0; i < length; i++) {
            int index = randomInt(0, length - 1);
            char old = array[i];
            array[i] = array[index];
            array[index] = old;
        }

        return new String(array);
    }
}
