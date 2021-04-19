package com.sbt.homework.exceptionshw.terminal;

public class PinValidator {

    public static boolean checkPin(String pin, BankAccount account) {
        return account.getPin().equals(pin);
    }
}
