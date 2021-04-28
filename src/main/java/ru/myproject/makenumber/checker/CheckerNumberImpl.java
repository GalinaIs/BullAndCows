package ru.myproject.makenumber.checker;

import org.springframework.stereotype.Component;
import ru.myproject.makenumber.BullsCows;

@Component
public class CheckerNumberImpl implements CheckerNumber {
    @Override
    public BullsCows checkNumber(String inputtedNumber, String expectedNumber) {
        return null;
    }
}
