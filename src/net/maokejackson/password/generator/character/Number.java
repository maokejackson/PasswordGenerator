package net.maokejackson.password.generator.character;

/**
 * Created by Maoke Jackson on 19/10/2014.
 */
public class Number extends Character {
    @Override
    String getAvailableCharacters() {
        return "0123456789";
    }
}
