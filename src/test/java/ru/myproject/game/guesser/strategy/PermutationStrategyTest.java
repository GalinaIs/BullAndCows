package ru.myproject.game.guesser.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.myproject.game.BullsCows;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс PermutationStrategy ")
class PermutationStrategyTest {
    @Test
    @DisplayName("должен вернуть пустой Optional, если отгадываем число из 1 элемента и пользователь на все варианты ответил, что ни одной коровы и ни одного быка")
    void shouldReturnEmptyOptionalForNumberWithLength1() {
        PermutationStrategy permutationStrategy = new PermutationStrategy(1);
        Optional<String> number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("0", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("1", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("2", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("3", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("4", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("5", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("6", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("7", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("8", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("9", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        System.out.println(number);
        assertFalse(number.isPresent());
    }

    @Test
    @DisplayName("должен найти загаданное число длины 1")
    void shouldFindNumberWithLength1() {
        // загадали число 9
        PermutationStrategy permutationStrategy = new PermutationStrategy(1);
        Optional<String> number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("0", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("1", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("2", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("3", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("4", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("5", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("6", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("7", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("8", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("9", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("9", number.get());
    }

    @Test
    @DisplayName("должен найти загаданное число длины 2")
    void shouldFindNumberWithLength2() {
        // загадали число 11
        PermutationStrategy permutationStrategy = new PermutationStrategy(2);
        Optional<String> number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("00", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("11", number.get());
        number = permutationStrategy.getNumber(new BullsCows(2, 0));
        assertTrue(number.isPresent());
        assertEquals("11", number.get());
    }

    @Test
    @DisplayName("должен найти загаданное число длины 2")
    void shouldFindNumberWithLength2_() {
        // загадали число 43
        PermutationStrategy permutationStrategy = new PermutationStrategy(2);
        Optional<String> number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("00", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("11", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("22", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("33", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("44", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("30", number.get());
        number = permutationStrategy.getNumber(new BullsCows(0, 1));
        assertTrue(number.isPresent());
        assertEquals("03", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("43", number.get());
    }

    @Test
    @DisplayName("должен найти загаданное число длины 3")
    void shouldFindNumberWithLength3() {
        // загадали число 321
        PermutationStrategy permutationStrategy = new PermutationStrategy(3);
        Optional<String> number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("000", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("111", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("222", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("333", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("100", number.get());
        number = permutationStrategy.getNumber(new BullsCows(0, 1));
        assertTrue(number.isPresent());
        assertEquals("010", number.get());
        number = permutationStrategy.getNumber(new BullsCows(0, 1));
        assertTrue(number.isPresent());
        assertEquals("001", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("201", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 1));
        assertTrue(number.isPresent());
        assertEquals("021", number.get());
        number = permutationStrategy.getNumber(new BullsCows(2, 0));
        assertTrue(number.isPresent());
        assertEquals("321", number.get());
        number = permutationStrategy.getNumber(new BullsCows(3, 0));
        assertTrue(number.isPresent());
        assertEquals("321", number.get());
    }

    @Test
    @DisplayName("должен найти загаданное число длины 6")
    void shouldFindNumberWithLength6() {
        // загадали число 214365
        PermutationStrategy permutationStrategy = new PermutationStrategy(6);
        Optional<String> number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("000000", number.get());
        number = permutationStrategy.getNumber(new BullsCows());
        assertTrue(number.isPresent());
        assertEquals("111111", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("222222", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("333333", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("444444", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("555555", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("666666", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("100000", number.get());
        number = permutationStrategy.getNumber(new BullsCows(0, 1));
        assertTrue(number.isPresent());
        assertEquals("010000", number.get());
        number = permutationStrategy.getNumber(new BullsCows(1, 0));
        assertTrue(number.isPresent());
        assertEquals("210000", number.get());
        number = permutationStrategy.getNumber(new BullsCows(2, 0));
        assertTrue(number.isPresent());
        assertEquals("213000", number.get());
        number = permutationStrategy.getNumber(new BullsCows(2, 1));
        assertTrue(number.isPresent());
        assertEquals("210300", number.get());
        number = permutationStrategy.getNumber(new BullsCows(3, 0));
        assertTrue(number.isPresent());
        assertEquals("214300", number.get());
        number = permutationStrategy.getNumber(new BullsCows(4, 0));
        assertTrue(number.isPresent());
        assertEquals("214350", number.get());
        number = permutationStrategy.getNumber(new BullsCows(4, 1));
        assertTrue(number.isPresent());
        assertEquals("214305", number.get());
        number = permutationStrategy.getNumber(new BullsCows(5, 0));
        assertTrue(number.isPresent());
        assertEquals("214365", number.get());
        number = permutationStrategy.getNumber(new BullsCows(6, 0));
        assertTrue(number.isPresent());
        assertEquals("214365", number.get());
    }
}