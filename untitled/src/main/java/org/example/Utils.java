package org.example;

public class Utils {

    public static boolean inputIsInterger(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
