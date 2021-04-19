package com.sbt.homework.exceptionshw.terminal;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class TerminalImpl implements Terminal {

    private final BankAccount account;
    private boolean locked = false;
    private boolean authorized = false;
    private LocalDateTime accountLockedUntil;
    private int attemptsToLock = 3;

    public TerminalImpl(BankAccount account) {
        this.account = account;
    }

    @Override
    public boolean isAuthorized() {
        return authorized;
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public LocalDateTime getAccountLockedUntil() {
        return accountLockedUntil;
    }

    @Override
    public boolean enterPin(String pin) throws AccountIsLockedException {
        if (locked) {
            if (LocalDateTime.now().isBefore(accountLockedUntil)) {
                throw new AccountIsLockedException(LocalDateTime.now().until(accountLockedUntil, ChronoUnit.SECONDS));
            } else {
                locked = false;
                attemptsToLock = 3;
            }
        }
        if (PinValidator.checkPin(pin, account)) {
            authorized = true;
            return true;
        }
        attemptsToLock--;
        if (attemptsToLock == 0) {
            locked = true;
            accountLockedUntil = LocalDateTime.now().plus(10, ChronoUnit.SECONDS);
        }
        return false;
    }

    @Override
    public BigDecimal putMoney(BigDecimal amount) {
        return TerminalServer.putMoney(account, amount);
    }

    @Override
    public BigDecimal withdrawMoney(BigDecimal amount) {
        return TerminalServer.withdrawMoney(account, amount);
    }

    @Override
    public BigDecimal getAmountMoney() {
        return TerminalServer.getAmountMoney(account);
    }

    @Override
    public int getAttemptsToLock() {
        return attemptsToLock;
    }

}
