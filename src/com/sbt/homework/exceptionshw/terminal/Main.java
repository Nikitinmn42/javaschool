package com.sbt.homework.exceptionshw.terminal;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;


public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("1111",
                Currency.getInstance(Locale.getDefault()),
                new BigDecimal(10000));
        Terminal terminal = new TerminalImpl(account);
        TerminalUserInterface terminalUI = new ConsoleUI(terminal);
        terminalUI.start();
    }

}
