package com.sbt.homework.exceptionshw.terminal;

import java.math.BigDecimal;
import java.util.Currency;


public class BankAccount {

    private final String pin;
    private final Currency currency;
    private BigDecimal amount;

    public BankAccount(String pin, Currency currency, BigDecimal amount) {
        this.pin = pin;
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPin() {
        return pin;
    }
}
