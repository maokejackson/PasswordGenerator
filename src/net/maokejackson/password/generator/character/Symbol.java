package net.maokejackson.password.generator.character;

/**
 * Created by Maoke Jackson on 19/10/2014.
 */
public class Symbol extends Character {
    private static Symbol instance;

    private Symbol() {

    }

    public static Symbol getInstance() {
        if (instance == null) {
            instance = new Symbol();
        }
        return instance;
    }

    @Override
    public String getCharacter() {
        return "!@#$%^&*_+|-={}[]()/\\'\"`~,;:.<>";
    }
}
