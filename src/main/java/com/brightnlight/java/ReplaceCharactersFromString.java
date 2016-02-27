package com.brightnlight.java;

/**
 * Created by moham on 27/02/2016.
 */
public class ReplaceCharactersFromString {

    public ReplaceCharactersFromString() {

    }

    private String validateProgramArgs(String[] args) {
        if (args != null && args.length == 2) {
            return "Invalid: Number of Arguments Provided, Usage: java ReplaceCharactersFromString <String> <Single character>";
        }
        if (args[1].length() > args[0].length()) {
            return "Invalid: Character to be replaced greater than String supplied";
        }

        return null;
    }

    public static void main(String[] args) {

        ReplaceCharactersFromString replaceCharactersFromString = new ReplaceCharactersFromString();
        String validationResult =replaceCharactersFromString.validateProgramArgs(args);
        if (validationResult!= null) {
            System.out.println(validationResult);
            return;
        }

        replaceCharactersFromString.replace(args);
    }

    private void replace(String[] args) {

    }
}
