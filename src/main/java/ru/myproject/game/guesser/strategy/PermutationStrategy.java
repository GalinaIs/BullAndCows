package ru.myproject.game.guesser.strategy;

import ru.myproject.game.BullsCows;

import java.util.Optional;

public class PermutationStrategy implements Strategy {
    private final int countDigits;
    private final char[] chars;
    private int index = -1;
    private int count;
    private Mode mode = Mode.INITIAL;
    private final int[] indexes;
    private int indexPermutation = -1;
    private final BullsCows perfectBullsCows;
    private Optional<String> previousResult;

    public PermutationStrategy(int countDigits) {
        this.countDigits = countDigits;
        chars = new char[countDigits];
        indexes = new int[countDigits];
        perfectBullsCows = new BullsCows(countDigits, 0);
    }

    @Override
    public Optional<String> getNumber(BullsCows bullsCows) {
        if (bullsCows.equals(perfectBullsCows)) {
            return previousResult;
        }
        if (mode == Mode.INITIAL) {
            updateInitialString(bullsCows);
        }
        mode = updateMode();
        previousResult = mode == Mode.INITIAL ? getStringInInitialMode() : getStringInPermutationMode();
        return previousResult;
    }

    private void updateInitialString(BullsCows bullsCows) {
        if (!bullsCows.equals(new BullsCows())) {
            for (int i = 0; i < bullsCows.getBulls(); i++) {
                chars[count + i] = Character.forDigit(index, 10);;
            }
            count += bullsCows.getBulls();
        }
    }

    private Mode updateMode() {
        return count < countDigits && index < 9 ? Mode.INITIAL : Mode.PERMUTATION;
    }

    private Optional<String> getStringInInitialMode() {
        return Optional.of(String.valueOf(++index).repeat(countDigits));
    }

    private Optional<String> getStringInPermutationMode() {
        if (indexPermutation == -1 && countDigits == 1) {
            return Optional.empty();
        }
        if (indexPermutation == -1) {
            indexPermutation++;
            return Optional.of(new String(chars));
        }
        while (indexPermutation < count) {
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

    private enum Mode {
        INITIAL, PERMUTATION;
    }
}
