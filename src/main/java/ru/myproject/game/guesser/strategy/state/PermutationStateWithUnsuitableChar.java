package ru.myproject.game.guesser.strategy.state;

import ru.myproject.game.BullsCows;

import java.util.AbstractMap;
import java.util.Optional;

public class PermutationStateWithUnsuitableChar implements State {
    private final int countDigits;
    private final char[] chars;
    private int charsIndex = -1;
    private final char[] checkedChars;
    private int checkedCharsIndex = -1;
    private final char unsuitableChar;
    private BullsCows previousBullsCows = new BullsCows();
    private char element;

    public PermutationStateWithUnsuitableChar(int countDigits, char[] chars, char unsuitableChar) {
        this.countDigits = countDigits;
        this.chars = chars;
        checkedChars = new char[countDigits];
        this.unsuitableChar = unsuitableChar;
    }

    @Override
    public AbstractMap.SimpleEntry<State, Optional<String>> getNextStateAndNumber(BullsCows bullsCows) {
        if (charsIndex == -1 && countDigits == 1) {
            return new AbstractMap.SimpleEntry<>(this, Optional.empty());
        }
        if (charsIndex != -1 && bullsCows.getBulls() > previousBullsCows.getBulls()) {
            fixElement();
        }
        element = getElement();
        previousBullsCows = bullsCows;
        return new AbstractMap.SimpleEntry<>(this, getString());
    }

    private char getElement() {
        return (charsIndex == -1 || checkedCharsIndex == countDigits) ? chars[++charsIndex] : element;
    }

    private void fixElement() {
        checkedChars[checkedCharsIndex] = element;
        checkedCharsIndex = countDigits;
    }

    private Optional<String> getString() {
        checkedCharsIndex = getNextIndex();
        if (checkedCharsIndex == -1) {
            return Optional.empty();
        }
        return Optional.of(createString());
    }

    private String createString() {
        char[] charsForString = new char[countDigits];
        System.arraycopy(checkedChars, 0, charsForString, 0, countDigits);
        for (int i = 0; i < countDigits; i++) {
            if (charsForString[i] == 0) {
                charsForString[i] = i == checkedCharsIndex ? chars[charsIndex] : unsuitableChar;
            }
        }
        return new String(charsForString);
    }

    private int getNextIndex() {
        if (checkedCharsIndex == countDigits) {
            checkedCharsIndex = -1;
        }
        checkedCharsIndex++;
        for (int i = checkedCharsIndex; i < checkedChars.length; i++) {
            if (checkedChars[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
