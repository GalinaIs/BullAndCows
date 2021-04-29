package ru.myproject.game.makenumber;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MakerRandomNumber implements MakerNumber {
    @Override
    public String makeNumber(int countDigits) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < countDigits; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }
}
