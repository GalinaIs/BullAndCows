package ru.myproject.makenumber.checker;

import ru.myproject.makenumber.BullsCows;

public interface CheckerNumber {
    BullsCows checkNumber(String inputtedNumber, String expectedNumber);
}
