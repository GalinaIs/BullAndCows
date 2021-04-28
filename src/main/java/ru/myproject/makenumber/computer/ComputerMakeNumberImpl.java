package ru.myproject.makenumber.computer;

import org.springframework.stereotype.Component;
import ru.myproject.makenumber.MakerNumber;

@Component
public class ComputerMakeNumberImpl implements ComputerMakeNumber {
    private final MakerNumber makerNumber;

    public ComputerMakeNumberImpl(MakerNumber makerNumber) {
        this.makerNumber = makerNumber;
    }

    @Override
    public void tryGuessNumber(int countDigits) {
        String guessedNumber = makerNumber.makeNumber(countDigits);
    }
}
