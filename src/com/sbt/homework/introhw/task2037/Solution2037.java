package com.sbt.homework.introhw.task2037;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Solution2037 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        List<String> wordsList = new ArrayList<>(Arrays.asList(words.split(",")));
        if (words.endsWith(",")) {
            wordsList.add("");
        }
        int minLength = Integer.parseInt(scanner.nextLine());
        System.out.println(wordsList.stream()
                .filter(word -> word.length() >= minLength)
                .collect(Collectors.joining(",")));
    }
}
