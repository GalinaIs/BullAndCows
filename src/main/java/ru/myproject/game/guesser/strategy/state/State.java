package ru.myproject.game.guesser.strategy.state;

import ru.myproject.game.BullsCows;

import java.util.AbstractMap;
import java.util.Optional;

public interface State {
    AbstractMap.SimpleEntry<State, Optional<String>> getNextStateAndNumber(BullsCows bullsCows);
}
