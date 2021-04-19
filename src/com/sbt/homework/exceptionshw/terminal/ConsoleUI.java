package com.sbt.homework.exceptionshw.terminal;

import java.math.BigDecimal;
import java.util.Scanner;


public class ConsoleUI implements TerminalUserInterface {

    private final Terminal terminal;
    Scanner scanner = new Scanner(System.in).useDelimiter("");

    public ConsoleUI(Terminal terminal) {
        this.terminal = terminal;
    }

    public void terminalMainMenu() {
        while (true) {
            if (!terminal.isAuthorized()) {
                try {
                    if (!terminal.enterPin(readPin())) {
                        showMessage("Wrong PIN. Attempts left: " + terminal.getAttemptsToLock());
                        continue;
                    }
                } catch (PinInputException e) {
                    continue;
                } catch (AccountIsLockedException e) {
                    showMessage("You entered wrong PIN 3 times. Account is locked for " +
                            e.getTimeToUnlock() + " sec");
                }
            }

            showMessage("Enter command (put, withdraw, get, exit): ");
            switch (readInput()) {
                case "put":
                    showMessage("Enter amount of money: ");
                    terminal.putMoney(new BigDecimal(readInput()));
                    break;
                case "withdraw":
                    showMessage("Enter amount of money: ");
                    try {
                        terminal.withdrawMoney(new BigDecimal(readInput()));
                    } catch (IllegalArgumentException e) {
                        showMessage(e.getMessage());
                    }
                    break;
                case "get":
                    System.out.println(terminal.getAmountMoney());
                    break;
                case "exit":
                    return;
                default:
                    showMessage("Wrong input.");
            }
        }
    }

    private String readPin() throws PinInputException {
        showMessage("Enter PIN (4 digits): ");
        String stringPin = readInput();
        if (stringPin.matches("\\d{4}")) {
            return stringPin;
        } else if (stringPin.length() != 4) {
            showMessage("PIN must be 4 digit");
        } else if (stringPin.matches(".*\\D.*")) {
            showMessage("Entered PIN contains non-digit character");
        }
        throw new PinInputException();
    }

    @Override
    public void start() {
        terminalMainMenu();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String readInput() {
        return scanner.nextLine();
    }
}
