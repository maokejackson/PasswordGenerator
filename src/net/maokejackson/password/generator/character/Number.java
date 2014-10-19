package net.maokejackson.password.generator.character;

/**
 * Created by Maoke Jackson on 19/10/2014.
 */
public class Number extends Character {
    private static Number instance;

    private Number() {

    }

    public static Number getInstance() {
        if (instance == null) {
            instance = new Number();
        }
        return instance;
    }

    @Override
    public String getCharacter() {
        return "0123456789";
    }
}
