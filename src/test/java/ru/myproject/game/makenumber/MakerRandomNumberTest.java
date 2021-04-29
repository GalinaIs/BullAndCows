package ru.myproject.game.makenumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Класс MakerNumberImpl ")
class MakerRandomNumberTest {
    private final MakerRandomNumber makerNumber = new MakerRandomNumber();

    @Test
    @DisplayName("должен загадывать число с заданным количеством цифр")
    void shouldMakeNumberWithGivenNumberDigits() {
        String guessedNumber = makerNumber.makeNumber(2);
        assertEquals(2, guessedNumber.length());
    }
}