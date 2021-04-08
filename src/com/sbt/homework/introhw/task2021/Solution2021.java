package com.sbt.homework.introhw.task2021;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Solution2021 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<Integer> integers = Arrays.stream(scanner.nextLine().split(" "))
                .limit(count)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> tempList = integers;
        for (int i = 0; i < 2; i++) {
            int max = Collections.max(tempList);
            tempList = tempList.stream()
                    .map(integer -> integer == max ? integer / 2 : integer)
                    .collect(Collectors.toList());
        }
        tempList.forEach(integer -> System.out.print(integer + " "));
    }
}
