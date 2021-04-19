package com.sbt.homework.exceptionshw.terminal;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public interface Terminal {

    boolean enterPin(String pin) throws AccountIsLockedException;

    boolean isAuthorized();

    BigDecimal putMoney(BigDecimal amount);

    BigDecimal withdrawMoney(BigDecimal amount);

    BigDecimal getAmountMoney();

    LocalDateTime getAccountLockedUntil();

    int getAttemptsToLock();
}