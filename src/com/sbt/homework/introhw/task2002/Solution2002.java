package com.sbt.homework.introhw.task2002;

import java.util.Scanner;


public class Solution2002 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int accum = 0;
        for (int i = 0; i < count; i++) {
            accum += scanner.nextInt();
        }
        System.out.println(accum);
    }
}
