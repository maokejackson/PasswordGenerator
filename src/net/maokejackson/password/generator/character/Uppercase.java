package net.maokejackson.password.generator.character;

/**
 * Created by Maoke Jackson on 19/10/2014.
 */
public class Uppercase extends Character {
    @Override
    String getAvailableCharacters() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }
}
