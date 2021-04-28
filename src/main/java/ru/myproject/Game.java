package ru.myproject;

import org.springframework.stereotype.Component;
import ru.myproject.makenumber.computer.ComputerMakeNumber;

import java.util.Scanner;

@Component
public class Game {
    private final ComputerMakeNumber computerMakeNumber;
    private final Scanner scanner;

    public Game(ComputerMakeNumber computerMakeNumber) {
        this.computerMakeNumber = computerMakeNumber;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Введите режим игры: 1 - число загадывает компьютер, 2 - число загадывает человек");
        int mode = scanner.nextInt();

        switch (mode) {
            case 1:
                int countDigits = getCountDigitsFromUser();
                computerMakeNumber.tryGuessNumber(countDigits);
                break;
            case 2:
                break;
            default:
                throw new IllegalArgumentException("Значение " + mode + " не поддерживается");
        }
    }

    private int getCountDigitsFromUser() {
        System.out.println("Введите количество цифр в числе - от 1 до 10");
        int countDigits = scanner.nextInt();
        if (countDigits < 1 || countDigits > 10) {
            throw new IllegalArgumentException("Количество цифр в числе должно быть от 1 до 10");
        }
        return countDigits;
    }
}
