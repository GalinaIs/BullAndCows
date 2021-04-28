package ru.myproject.makenumber;

public class BullsCows {
    private final int bulls;
    private final int cows;

    public BullsCows(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }

    public boolean isFinishedGame(int count) {
        return bulls == count && cows == 0;
    }

    @Override
    public String toString() {
        return bulls + " быков и " + cows + " коров";
    }
}
