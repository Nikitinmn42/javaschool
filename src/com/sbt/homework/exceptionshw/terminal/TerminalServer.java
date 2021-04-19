package com.sbt.homework.exceptionshw.terminal;

import java.math.BigDecimal;


public class TerminalServer {

    public static BigDecimal putMoney(BankAccount account, BigDecimal amount) {
        account.setAmount(account.getAmount().add(amount));
        return account.getAmount();
    }

    public static BigDecimal withdrawMoney(BankAccount account, BigDecimal amount) {
        if (!amount.divideAndRemainder(new BigDecimal(100))[1].equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("Amount must be a multiple of 100");
        } else if (amount.compareTo(account.getAmount()) > 0) {
            throw new IllegalArgumentException("Insufficient funds in the account");
        }
        account.setAmount(account.getAmount().subtract(amount));
        return account.getAmount();
    }

    public static BigDecimal getAmountMoney(BankAccount account) {
        return account.getAmount();
    }

}
