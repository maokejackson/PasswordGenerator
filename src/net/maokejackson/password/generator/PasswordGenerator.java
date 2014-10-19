package net.maokejackson.password.generator;

import net.maokejackson.password.generator.character.Character;
import net.maokejackson.password.generator.character.*;
import net.maokejackson.password.generator.character.Number;

import java.util.Vector;

/**
 * Created by Maoke Jackson on 19/10/2014.
 */
public class PasswordGenerator {
    private int length;
    private boolean allowLowercase = true;
    private boolean allowUppercase = true;
    private boolean allowNumber = true;
    private boolean allowSymbol = true;
    private boolean excludeSimilar;
    private boolean excludeAmbiguous;

    public PasswordGenerator(int length) {
        this.length = length;
    }

    public String generate() {
        return generate(length);
    }

    public String generate(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("password length must be positive and greater than zero");
        }

        Vector<Character> sets = createCharacterSets();

        if (sets.isEmpty()) {
            throw new IllegalArgumentException("character set cannot be empty");
        }

        int remainingLength = length;
        StringBuilder builder = new StringBuilder(length);

        for (int i = sets.size() - 1, index = 0; i >= 0; i--, index++) {
            Character character = sets.get(index);
            int passLength = i == 0 ? remainingLength : RandomUtil.randomInt(remainingLength / (i + 1), remainingLength - i);
            String password = character.generate(passLength);
            builder.append(password);
            remainingLength -= passLength;
        }

        return RandomUtil.randomSwap(builder.toString());
    }

    private Vector<Character> createCharacterSets() {
        Vector<Character> sets = new Vector<>();

        Character.setExcludeSimilar(isExcludeSimilar());
        Character.setExcludeAmbiguous(isExcludeAmbiguous());

        if (isAllowLowercase()) sets.add(new Lowercase());
        if (isAllowUppercase()) sets.add(new Uppercase());
        if (isAllowNumber()) sets.add(new Number());
        if (isAllowSymbol()) sets.add(new Symbol());

        return sets;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isAllowLowercase() {
        return allowLowercase;
    }

    public void setAllowLowercase(boolean allowLowercase) {
        this.allowLowercase = allowLowercase;
    }

    public boolean isAllowUppercase() {
        return allowUppercase;
    }

    public void setAllowUppercase(boolean allowUppercase) {
        this.allowUppercase = allowUppercase;
    }

    public boolean isAllowNumber() {
        return allowNumber;
    }

    public void setAllowNumber(boolean allowNumber) {
        this.allowNumber = allowNumber;
    }

    public boolean isAllowSymbol() {
        return allowSymbol;
    }

    public void setAllowSymbol(boolean allowSymbol) {
        this.allowSymbol = allowSymbol;
    }

    public boolean isExcludeSimilar() {
        return excludeSimilar;
    }

    public void setExcludeSimilar(boolean excludeSimilar) {
        this.excludeSimilar = excludeSimilar;
    }

    public boolean isExcludeAmbiguous() {
        return excludeAmbiguous;
    }

    public void setExcludeAmbiguous(boolean excludeAmbiguous) {
        this.excludeAmbiguous = excludeAmbiguous;
    }

    public static void main(String[] args) {
        int length = 15;
        int counter = 10;

        long startTime = System.nanoTime();

        PasswordGenerator generator = new PasswordGenerator(length);
        generator.setAllowLowercase(true);
        generator.setAllowUppercase(true);
        generator.setAllowNumber(true);
        generator.setAllowSymbol(true);
        generator.setExcludeSimilar(true);
        generator.setExcludeAmbiguous(true);

        try {
            for (int count = 0; count < counter; count++) {
                String password = generator.generate();
                System.out.println("random password: " + password);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("time spent: " + duration + "ms");
    }
}
