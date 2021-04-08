package com.sbt.homework.introhw.task2036;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Solution2036 {

    public static void main(String[] args) {
        List<String> wordsList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String word = scanner.nextLine();
            if (!word.matches(".*[eyuioa]{3,}.*")) {
                wordsList.add(word);
            }
        }
        wordsList.forEach(System.out::println);
    }
}
