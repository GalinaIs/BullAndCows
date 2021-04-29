package ru.myproject.game.guesser;

import org.springframework.stereotype.Component;
import ru.myproject.game.BullsCows;
import ru.myproject.game.guesser.strategy.Strategy;

import java.util.Optional;
import java.util.Scanner;

@Component
public class GuesserWhenPersonMakeNumber implements GuesserNumber {
    private final Scanner scanner;

    public GuesserWhenPersonMakeNumber() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void tryGuessNumber(int countDigits) {
        Strategy strategy = Strategy.getStrategy(countDigits);
        BullsCows bullsCows = new BullsCows();
        Optional<String> number;
        do {
            number = strategy.getNumber(bullsCows);
            if (number.isPresent()) {
                bullsCows = checkNumber(number.get());
            }
        } while (number.isPresent() && bullsCows.isFinishedGame(countDigits));
        System.out.println(number.isPresent() ? "Ура! Я выиграл - загаданное число " + number : "Я проиграл - не нашел нужное число");
    }

//    private String getInitialString(int countDigits) {
//        StringBuilder sb = new StringBuilder();
//        int count = 0;
//        BullsCows empty = new BullsCows();
//        for (int i = 0; i <= 9 && count < countDigits; i++) {
//            BullsCows bullsCows = checkNumber(String.valueOf(i).repeat(countDigits));
//            if (!bullsCows.equals(empty)) {
//                sb.append(String.valueOf(i).repeat(bullsCows.getBulls()));
//                count += bullsCows.getBulls();
//            }
//        }
//        return sb.toString();
//    }

    private BullsCows checkNumber(String number) {
        System.out.println("Я предполагаю, что это число " + number);
        int bulls = getNextInt("Введите количество быков");
        int cows = getNextInt("Введите количество коров");
        return new BullsCows(bulls, cows);
    }

    private int getNextInt(String message) {
        while (true) {
            System.out.println(message);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Введенное значение не является целым числом");
                scanner.next();
            }
        }
    }

//    Optional<String> checkPermutations(char[] chars, int count, BullsCows perfectBullsCows) {
//        if (count == 1) {
//            return Optional.of(new String(chars));
//        }
//        int[] indexes = new int[count];
//        for (int i = 0; i < count; i++) {
//            indexes[i] = 0;
//        }
//        if (isFinish(chars, perfectBullsCows)) {
//            return Optional.of(new String(chars));
//        }
//        int i = 0;
//        while (i < count) {
//            if (indexes[i] < i) {
//                swap(chars, i % 2 == 0 ? 0 : indexes[i], i);
//                if (isFinish(chars, perfectBullsCows)) {
//                    return Optional.of(new String(chars));
//                }
//                indexes[i]++;
//                i = 0;
//            } else {
//                indexes[i] = 0;
//                i++;
//            }
//        }
//        return Optional.empty();
//    }

//    private boolean isFinish(char[] chars, BullsCows perfectBullsCows) {
//        BullsCows bullsCows = checkNumber(new String(chars));
//        return bullsCows.equals(perfectBullsCows);
//    }
}
