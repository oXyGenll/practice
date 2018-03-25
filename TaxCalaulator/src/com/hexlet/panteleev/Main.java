package com.hexlet.panteleev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Введите сумму: ");
        Scanner scan = new Scanner(System.in);
        double cash = scan.nextDouble();

        System.out.println("Введите проценты: ");
        Scanner scan1 = new Scanner(System.in);
        double percent = scan1.nextDouble();

        double endSum = (cash*percent)/100 + cash;
        System.out.println("Сумма с учетом процентов: " + endSum);
    }
}
