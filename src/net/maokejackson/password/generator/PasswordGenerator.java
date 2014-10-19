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
    private Vector<Character> characterTypes = new Vector<>();

    public PasswordGenerator(int length) {
        this.length = length;
        Character.setExcludeSimilar(true);
        Character.setExcludeAmbiguous(true);
        characterTypes.add(Lowercase.getInstance());
        characterTypes.add(Uppercase.getInstance());
        characterTypes.add(Number.getInstance());
        characterTypes.add(Symbol.getInstance());
    }

    public String generate() {
        int count = characterTypes.size();
        int countLeft = length;
        StringBuilder builder = new StringBuilder(length);

        for (int i = count - 1, index = 0; i >= 0; i--, index++) {
            Character character = characterTypes.get(index);
            int passLength = i == 0 ? countLeft : RandomUtil.randomInt(countLeft / (i + 1), countLeft - i);
            String password = character.generate(passLength);
            builder.append(password);
            countLeft -= passLength;
        }

        return RandomUtil.randomSwap(builder.toString());
    }

    public static void main(String[] args) {
        int length = 8;
        int counter = 10;

        PasswordGenerator generator = new PasswordGenerator(length);

        for (int count = 0; count < counter; count++) {
            String password = generator.generate();
            System.out.println("random password: " + password);
        }
    }
}
