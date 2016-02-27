package com.brightnlight.java;

/**
 * Created by moham on 27/02/2016.
 */
public class ReplaceCharactersFromString {

    public ReplaceCharactersFromString() {

    }

    private String validateProgramArgs(String[] args) {
        if (args == null || args!=null && args[0] != null && args.length==1) {
            return "Invalid: Number of arguments provided, Usage: java ReplaceCharactersFromString <String> <Single character>";
        }
        if (args != null &&  args[1].length() > 1) {
            return "Invalid: Character to be replaced length greater than 1";
        }
        if (args != null && args[1].length() > args[0].length()) {
            return "Invalid: Character to be replaced length greater than String supplied";
        }
        return null;
    }

    public static void main(String[] args) {
        ReplaceCharactersFromString replaceCharactersFromString = new ReplaceCharactersFromString();
        replaceCharactersFromString.replace(args);
    }

    public String replace(String[] args) {
       // String[] args = {string, String.valueOf(character)};
        String validationResult =validateProgramArgs(args);
        if (validationResult!= null) {
            System.out.println(validationResult);
            return validationResult;
        }
        return "";

        //charAt()
        //subString()
        //Iteration
        //Recursion
    }
}
