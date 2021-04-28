package ru.myproject.computer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс ComputerMakeNumberImplTest ")
class ComputerMakeNumberImplTest {
    private final ComputerMakeNumberImpl computerMakeNumber = new ComputerMakeNumberImpl();

    @Test
    @DisplayName("должен загадывать число с заданным количеством цифр")
    void shouldGuessNumberWithGivenNumberDigits() {
        String guessedNumber = computerMakeNumber.guessNumber(2);
        assertEquals(2, guessedNumber.length());
    }
}