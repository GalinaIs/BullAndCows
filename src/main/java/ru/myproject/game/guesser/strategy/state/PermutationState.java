package ru.myproject.game.guesser.strategy.state;

import ru.myproject.game.BullsCows;

import java.util.AbstractMap;
import java.util.Optional;

public class PermutationState implements State {
    private final int countDigits;
    private final char[] chars;
    private final int[] indexes;
    private int indexPermutation = -1;

    public PermutationState(int countDigits, char[] chars) {
        this.countDigits = countDigits;
        this.chars = chars;
        indexes = new int[countDigits];
    }

    @Override
    public AbstractMap.SimpleEntry<State, Optional<String>> getNextStateAndNumber(BullsCows bullsCows) {
        return new AbstractMap.SimpleEntry<>(this, getString());
    }

    private Optional<String> getString() {
        if (indexPermutation == -1 && countDigits == 1) {
            return Optional.empty();
        }
        if (indexPermutation == -1) {
            indexPermutation++;
            return Optional.of(new String(chars));
        }
        while (indexPermutation < countDigits) {
            if (indexes[indexPermutation] < indexPermutation) {
                swap(chars, indexPermutation % 2 == 0 ? 0 : indexes[indexPermutation], indexPermutation);
                indexes[indexPermutation]++;
                indexPermutation = 0;
                return Optional.of(new String(chars));
            } else {
                indexes[indexPermutation] = 0;
                indexPermutation++;
            }
        }
        return Optional.empty();
    }

    private void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }
}
