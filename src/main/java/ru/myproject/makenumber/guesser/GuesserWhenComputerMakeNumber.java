package ru.myproject.makenumber.guesser;

import org.springframework.stereotype.Component;
import ru.myproject.makenumber.BullsCows;
import ru.myproject.makenumber.MakerNumber;
import ru.myproject.makenumber.checker.CheckerString;

import java.util.Scanner;

@Component
public class GuesserWhenComputerMakeNumber implements GuesserNumber {
    private final MakerNumber makerNumber;
    private final Scanner scanner;
    private final CheckerString checkerString;

    public GuesserWhenComputerMakeNumber(MakerNumber makerNumber, CheckerString checkerString) {
        this.makerNumber = makerNumber;
        this.scanner = new Scanner(System.in);
        this.checkerString = checkerString;
    }

    @Override
    public void tryGuessNumber(int countDigits) {
        String madeNumber = makerNumber.makeNumber(countDigits);
        tryGuessNumber(madeNumber, countDigits);
    }

    private void tryGuessNumber(String madeNumber, int countDigits) {
        boolean isFinish = false;
        while (!isFinish) {
            String next = getNextFromUser();
            if (next.equals("q")) {
                isFinish = true;
            } else if (next.length() != countDigits) {
                System.out.println("Вы ввели неверное число. Количество цифр в числе должно быть равно " + countDigits);
            } else {
                BullsCows bullsCows = checkerString.checkString(next, madeNumber);
                if (bullsCows.isFinishedGame(countDigits)) {
                    System.out.println("Поздравляю! Вы угадали число! Игра окончена");
                    isFinish = true;
                } else {
                    System.out.println("По введенному числу получено " + bullsCows);
                }
            }
        }
    }

    private String getNextFromUser() {
        while(true) {
            System.out.println("Введите число или 'q' для выхода");
            if (scanner.hasNext("(\\d+)|q")) {
                return scanner.next("(\\d+)|q");
            } else {
                System.out.println("Введенное значение не является ни числом, ни 'q' - обработать его невозможно");
                scanner.next();
            }
        }
    }
}
