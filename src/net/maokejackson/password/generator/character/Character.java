package net.maokejackson.password.generator.character;

import net.maokejackson.password.generator.RandomUtil;

/**
 * Created by Maoke Jackson on 19/10/2014.
 */
public abstract class Character {
    static boolean excludeSimilar;
    static boolean excludeAmbiguous;

    abstract String getAvailableCharacters();

    String getCharacters() {
        String character = getAvailableCharacters();
        if (isExcludeAmbiguous()) {
            character = character.replaceAll("[{}\\[\\]()/\\\\'\"`~,;:.<>]", "");
        }
        if (isExcludeSimilar()) {
            character = character.replaceAll("[iIlL1oO0]", "");
        }
        return character;
    }

    public String generate(int length) {
        String characters = getCharacters();
        StringBuilder builder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = RandomUtil.randomInt(0, characters.length() - 1);
            builder.append(characters.charAt(index));
        }

        return builder.toString();
    }

    public static boolean isExcludeSimilar() {
        return excludeSimilar;
    }

    public static void setExcludeSimilar(boolean excludeSimilar) {
        Character.excludeSimilar = excludeSimilar;
    }

    public static boolean isExcludeAmbiguous() {
        return excludeAmbiguous;
    }

    public static void setExcludeAmbiguous(boolean excludeAmbiguous) {
        Character.excludeAmbiguous = excludeAmbiguous;
    }
}
