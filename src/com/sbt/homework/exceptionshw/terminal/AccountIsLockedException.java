package com.sbt.homework.exceptionshw.terminal;

public class AccountIsLockedException extends Exception {

    private final long timeToUnlock;

    public AccountIsLockedException(long timeToUnlock) {
        this.timeToUnlock = timeToUnlock;
    }

    public long getTimeToUnlock() {
        return timeToUnlock;
    }
}
