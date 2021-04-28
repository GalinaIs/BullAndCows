package ru.myproject.makenumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Класс MakerNumberImpl ")
class MakerNumberImplTest {
    private final MakerNumberImpl makerNumber = new MakerNumberImpl();

    @Test
    @DisplayName("должен загадывать число с заданным количеством цифр")
    void shouldGuessNumberWithGivenNumberDigits() {
        String guessedNumber = makerNumber.makeNumber(2);
        assertEquals(2, guessedNumber.length());
    }
}