package ru.myproject.computer;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ComputerMakeNumberImpl implements ComputerMakeNumber {
    @Override
    public void tryGuessNumber(int countDigits) {
        String guessedNumber = guessNumber(countDigits);
    }

    String guessNumber(int countDigits) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < countDigits; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }
}
