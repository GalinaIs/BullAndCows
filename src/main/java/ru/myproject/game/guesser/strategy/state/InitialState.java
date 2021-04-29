package ru.myproject.game.guesser.strategy.state;

import ru.myproject.game.BullsCows;

import java.util.AbstractMap;
import java.util.Optional;

public class InitialState implements State {
    private final int countDigits;
    private final char[] chars;
    private int index = -1;
    private int count;
    private char unsuitableChar;

    public InitialState(int countDigits) {
        this.countDigits = countDigits;
        chars = new char[countDigits];
    }

    @Override
    public AbstractMap.SimpleEntry<State, Optional<String>> getNextStateAndNumber(BullsCows bullsCows) {
        updateInitialString(bullsCows);
        State state = updateState();
        return state == this ? new AbstractMap.SimpleEntry<>(this, getString()) : state.getNextStateAndNumber(bullsCows);
    }

    private void updateInitialString(BullsCows bullsCows) {
        if (!bullsCows.equals(new BullsCows())) {
            for (int i = 0; i < bullsCows.getBulls(); i++) {
                chars[count + i] = Character.forDigit(index, 10);
            }
            count += bullsCows.getBulls();
        }
        if (index != -1 && unsuitableChar == 0 && bullsCows.equals(new BullsCows())) {
            unsuitableChar = Character.forDigit(index, 10);
        }
    }

    private State updateState() {
        if (count < countDigits && index < 9) {
            return this;
        }
        return unsuitableChar != 0
                ? new PermutationStateWithUnsuitableChar(countDigits, chars, unsuitableChar)
                : new PermutationState(countDigits, chars);
    }

    private Optional<String> getString() {
        return Optional.of(String.valueOf(++index).repeat(countDigits));
    }
}
