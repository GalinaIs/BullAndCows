package ru.myproject.game.guesser.strategy;

import ru.myproject.game.BullsCows;

import java.util.Optional;

public interface Strategy {
    Optional<String> getNumber(BullsCows bullsCows);

    static Strategy getStrategy(int countDigits) {
        return new PermutationStrategy(countDigits);
    }
}
