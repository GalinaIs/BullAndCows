package ru.myproject.makenumber.checker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.myproject.makenumber.BullsCows;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс CheckerNumberImplTest ")
class CheckerStringImplTest {
    private final CheckerStringImpl checkerString = new CheckerStringImpl();

    @Test
    @DisplayName("должен возращать 1 бык и 0 коров")
    void shouldReturn1Bulls0Cows() {
        BullsCows bullsCows = checkerString.checkString("1", "12");
        assertEquals(new BullsCows(1, 0), bullsCows);
    }

    @Test
    @DisplayName("должен возращать 1 бык и 1 корову")
    void shouldReturn1Bulls1Cows() {
        BullsCows bullsCows = checkerString.checkString("123", "320");
        assertEquals(new BullsCows(1, 1), bullsCows);
    }

    @Test
    @DisplayName("должен возращать 1 бык и 1 корову")
    void shouldReturn1Bulls1Cows_() {
        BullsCows bullsCows = checkerString.checkString("5281", "1234");
        assertEquals(new BullsCows(1, 1), bullsCows);
    }

    @Test
    @DisplayName("должен возращать 4 быков и 0 коров")
    void shouldReturn4Bulls0Cows() {
        BullsCows bullsCows = checkerString.checkString("1234", "1234");
        assertEquals(new BullsCows(4, 0), bullsCows);
    }

    @Test
    @DisplayName("должен возращать 1 бык и 0 коров, но игра не окончена")
    void shouldReturn1Bulls0CowsButGameIsNotFinish() {
        BullsCows bullsCows = checkerString.checkString("13", "12");
        assertEquals(new BullsCows(1, 0), bullsCows);
        assertFalse(bullsCows.isFinishedGame(2));
    }

    @Test
    @DisplayName("должен возращать 2 бык и 0 коров и игра окончена")
    void shouldReturn2Bulls0CowsAndGameIsFinish() {
        BullsCows bullsCows = checkerString.checkString("13", "13");
        assertEquals(new BullsCows(2, 0), bullsCows);
        assertTrue(bullsCows.isFinishedGame(2));
    }

    @Test
    @DisplayName("должен возращать 3 быка и 0 коров и игра окончена")
    void should() {
        BullsCows bullsCows = checkerString.checkString("111", "111");
        assertEquals(new BullsCows(3, 0), bullsCows);
        assertTrue(bullsCows.isFinishedGame(3));
    }
}