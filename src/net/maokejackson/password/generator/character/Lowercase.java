package net.maokejackson.password.generator.character;

/**
 * Created by Maoke Jackson on 19/10/2014.
 */
public class Lowercase extends Character {
    private static Lowercase instance;

    private Lowercase() {

    }

    public static Lowercase getInstance() {
        if (instance == null) {
            instance = new Lowercase();
        }
        return instance;
    }

    @Override
    public String getCharacter() {
        return "abcdefghijklmnopqrstuvwxyz";
    }
}
