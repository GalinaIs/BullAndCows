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
        } while (number.isPresent() && !bullsCows.isFinishedGame(countDigits));
        System.out.println(number.map(s -> "Ура! Я выиграл - загаданное число " + s).orElse("Я проиграл - не нашел нужное число"));
    }

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
}
