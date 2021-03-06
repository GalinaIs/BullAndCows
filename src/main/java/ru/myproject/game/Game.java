package ru.myproject.game;

import org.springframework.stereotype.Component;
import ru.myproject.game.guesser.GuesserWhenComputerMakeNumber;
import ru.myproject.game.guesser.GuesserWhenPersonMakeNumber;

import java.util.Scanner;

@Component
public class Game {
    private final GuesserWhenComputerMakeNumber guesserWhenComputerMakeNumber;
    private final Scanner scanner;
    private final GuesserWhenPersonMakeNumber guesserWhenPersonMakeNumber;

    public Game(GuesserWhenComputerMakeNumber guesserWhenComputerMakeNumber, GuesserWhenPersonMakeNumber guesserWhenPersonMakeNumber) {
        this.guesserWhenComputerMakeNumber = guesserWhenComputerMakeNumber;
        this.guesserWhenPersonMakeNumber = guesserWhenPersonMakeNumber;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Введите режим игры: 1 - число загадывает компьютер, 2 - число загадывает человек");
        String mode = scanner.next();

        switch (mode) {
            case "1":
                int countDigits = getCountDigitsFromUser();
                guesserWhenComputerMakeNumber.tryGuessNumber(countDigits);
                break;
            case "2":
                int countDigits1 = getCountDigitsFromUser();
                guesserWhenPersonMakeNumber.tryGuessNumber(countDigits1);
                break;
            default:
                throw new IllegalArgumentException("Значение " + mode + " не поддерживается");
        }
    }

    private int getCountDigitsFromUser() {
        while (true) {
            System.out.println("Введите количество цифр в числе - от 1 до 10");
            if (scanner.hasNextInt()) {
                int countDigits = scanner.nextInt();
                if (countDigits >= 1 && countDigits <= 10) {
                    return countDigits;
                } else {
                    System.out.println("Число должно быть от 1 до 10");
                }
            } else {
                System.out.println("Введенное значение не является числом");
            }
            scanner.next();
        }
    }
}
