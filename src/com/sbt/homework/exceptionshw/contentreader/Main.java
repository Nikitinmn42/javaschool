package com.sbt.homework.exceptionshw.contentreader;

import java.io.IOException;
import java.net.IDN;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String userInput;
        while (true) {
            System.out.print("Enter URL to load page or exit: ");
            userInput = userInputScanner.nextLine();
            if ("exit".equals(userInput)) {
                System.exit(0);
            } else if (!isUrlCorrect(userInput)) {
                System.out.println("Wrong URL format: \"" + userInput +
                        "\"\nPlease enter URL in format \"https://www.example.com/\".");
            } else {
                readContent(encodeUrl(userInput));
            }
            System.out.println();
        }
    }


    private static boolean isUrlCorrect(String url) {
        return url.matches("(?U)https?://[-\\w+&@#/%?=~|!:,.;()]*[-\\w+&@#/%=~|()]");
    }

    private static void readContent(String url) {
        try (Scanner pageScanner = new Scanner(new URL(encodeUrl(url)).openStream()).useDelimiter("\n")) {
            pageScanner.tokens().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Can't load page by URL: " + url + ".\nPlease try again.");
        }
    }

    private static String encodeUrl(String url) {
        if (StandardCharsets.US_ASCII.newEncoder().canEncode(url)) {
            return url;
        }
        String[] urlSplit = url.split("(://)|/");
        return urlSplit[0] + "://" + IDN.toASCII(urlSplit[1]) + "/" +
                String.join("/", Arrays.copyOfRange(urlSplit, 2, urlSplit.length));
    }
}
