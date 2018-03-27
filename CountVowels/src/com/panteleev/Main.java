package com.panteleev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите строку: ");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        char[] vowels = {'a', 'o', 'i', 'y', 'u', 'e'};

        char[] chars = str.toCharArray();
        int k = 0;
        for (char aChar1 : chars) {
            for (char vowel : vowels) {
                if (aChar1 == vowel) {
                    k++;
                }
            }
        }

        char[] spaces= {' '};
        int m = 0;
        for (char aChar : chars) {
            for (char aSpaces : spaces) {
                if (aChar == aSpaces) {
                    m++;
                }
            }
        }
        System.out.println(str);
        System.out.println("Колличество гласных букв: " + k);
        System.out.println("Колличество пробелов: " + m);
    }
}
