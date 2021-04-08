package com.sbt.homework.introhw.task2022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Solution2022 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<Integer> tempList = Arrays.stream(scanner.nextLine().split(" "))
                .limit(count)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int pairs = 0;
        for (int i = 0; i < tempList.size(); i++) {
            int num1 = tempList.get(i);
            for (int j = i + 1; j < tempList.size(); j++) {
                int num2 = tempList.get(j);
                if (num1 % num2 == 0) {
                    pairs++;
                }
                if (num2 % num1 == 0) {
                    pairs++;
                }
            }
        }
        System.out.println(pairs);
    }
}
