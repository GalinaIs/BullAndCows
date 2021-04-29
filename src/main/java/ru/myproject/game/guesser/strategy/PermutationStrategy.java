package ru.myproject.game.guesser.strategy;

import ru.myproject.game.BullsCows;
import ru.myproject.game.guesser.strategy.state.InitialState;
import ru.myproject.game.guesser.strategy.state.State;

import java.util.AbstractMap;
import java.util.Optional;

public class PermutationStrategy implements Strategy {
    private final BullsCows perfectBullsCows;
    private State state;
    private Optional<String> previousResult;

    public PermutationStrategy(int countDigits) {
        perfectBullsCows = new BullsCows(countDigits, 0);
        state = new InitialState(countDigits);
    }

    @Override
    public Optional<String> getNumber(BullsCows bullsCows) {
        if (bullsCows.equals(perfectBullsCows)) {
            return previousResult;
        }
        AbstractMap.SimpleEntry<State, Optional<String>> nextStateAndNumber = state.getNextStateAndNumber(bullsCows);
        state = nextStateAndNumber.getKey();
        previousResult = nextStateAndNumber.getValue();
        return previousResult;
    }
}
