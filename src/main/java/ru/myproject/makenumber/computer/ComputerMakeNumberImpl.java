package ru.myproject.makenumber.computer;

import org.springframework.stereotype.Component;
import ru.myproject.makenumber.BullsCows;
import ru.myproject.makenumber.MakerNumber;
import ru.myproject.makenumber.checker.CheckerNumber;

import java.util.Scanner;

@Component
public class ComputerMakeNumberImpl implements ComputerMakeNumber {
    private final MakerNumber makerNumber;
    private final Scanner scanner;
    private final CheckerNumber checkerNumber;

    public ComputerMakeNumberImpl(MakerNumber makerNumber, CheckerNumber checkerNumber) {
        this.makerNumber = makerNumber;
        this.scanner = new Scanner(System.in);
        this.checkerNumber = checkerNumber;
    }

    @Override
    public void tryGuessNumber(int countDigits) {
        String madeNumber = makerNumber.makeNumber(countDigits);
        tryGuessNumber(madeNumber, countDigits);
    }

    private void tryGuessNumber(String madeNumber, int countDigits) {
        boolean isFinish = false;
        while (!isFinish) {
            System.out.println("Введите число или 'q' для выхода");
            String next = scanner.next("(\\d+)|q");
            if (next.equals("q")) {
                isFinish = true;
            } else if (next.length() != countDigits) {
                System.out.println("Вы ввели неверное число. Количество цифр в числе должно быть равно " + countDigits);
            } else {
                BullsCows bullsCows = checkerNumber.checkNumber(next, madeNumber);
                if (bullsCows.isFinishedGame(countDigits)) {
                    System.out.println("Поздравляю! Вы угадали число! Игра окончена");
                    isFinish = true;
                } else {
                    System.out.println("По введенному числу получено " + bullsCows);
                }
            }
        }
    }
}
