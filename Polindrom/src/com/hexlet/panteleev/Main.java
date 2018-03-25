package com.hexlet.panteleev;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        // write your code here

        System.out.println(isPalindrome("Madam, I'm Adam!"));
    }

    private static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
       StringBuilder reversText = new StringBuilder(text);
       reversText.reverse();
        return text.equals(reversText.toString());

    }
}
