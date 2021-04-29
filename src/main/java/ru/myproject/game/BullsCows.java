package ru.myproject.game;

import java.util.Objects;

public class BullsCows {
    private int bulls;
    private int cows;

    public BullsCows() {
    }

    public BullsCows(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }

    public void add(BullsCows other) {
        bulls += other.bulls;
        cows += other.cows;
    }

    public boolean isFinishedGame(int count) {
        return bulls == count && cows == 0;
    }

    public int getBulls() {
        return bulls;
    }

    @Override
    public String toString() {
        return bulls + " быков и " + cows + " коров";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BullsCows bullsCows = (BullsCows) o;
        return bulls == bullsCows.bulls && cows == bullsCows.cows;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bulls, cows);
    }
}
