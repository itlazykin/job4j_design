package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            String correctAnswer = getFizzBuzzValue(startAt);
            System.out.println(correctAnswer);
            String userAnswer = input.nextLine();
            if (!checkUserAnswer(startAt, userAnswer)) {
                System.out.println("Mistake!ujojaaaa! Try again =)");
                startAt = 1;
                continue;
            }
            startAt++;
        }
    }

    static String getFizzBuzzValue(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }

    static boolean checkUserAnswer(int number, String userAnswer) {
        return getFizzBuzzValue(number).equals(userAnswer);
    }
}
