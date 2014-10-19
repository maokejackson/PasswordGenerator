package net.maokejackson.password.generator.character;

/**
 * Created by Maoke Jackson on 19/10/2014.
 */
public class Uppercase extends Character {
    private static Uppercase instance;

    private Uppercase() {

    }

    public static Uppercase getInstance() {
        if (instance == null) {
            instance = new Uppercase();
        }
        return instance;
    }

    @Override
    public String getCharacter() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }
}
