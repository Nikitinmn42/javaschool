package com.sbt.homework.collectionshw.additionaltasks;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;


public class Main {

    private final static String PATH = "src/com/sbt/homework/collectionshw/additionaltasks/words.txt";

    public static void main(String[] args) {
        // TASK 1
        System.out.println("Distinct words in file: " + countDistinctWords());
        System.out.println();

        // TASK 2
        System.out.println("Distinct words sorted in ascending order by length: ");
        distinctSortedAsc().forEach(System.out::println);
        System.out.println();

        // TASK 3
        System.out.println("Counting word repetitions:");
        countRepetitions().forEach((word, count) -> System.out.println("Word: " + word + " repeated: " + count));
        System.out.println();

        // TASK 4
        System.out.println("All lines in reversed order: ");
        reverseOrderLines().forEach(System.out::println);
        System.out.println();

        // TASK 5
        System.out.println("Using reverse iterator to get distinct words sorted in descending order by length: ");
        List<String> strings = List.copyOf(distinctSortedAsc());
        reverseIterator(strings).forEachRemaining(System.out::println);
        System.out.println();

        // TASK 6
        System.out.println("Requesting lines 9, 3, 5: ");
        linesByNumbers(9, 3, 5).forEach(System.out::println);
    }

    // TASK 1
    private static int countDistinctWords() {
        Set<String> distinctWords = new HashSet<>();
        try (Scanner scanner = new Scanner(Path.of(PATH))) {
            while (scanner.hasNextLine()) {
                distinctWords.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return distinctWords.size();
    }

    // TASK 2
    private static Set<String> distinctSortedAsc() {
        Set<String> distinctWords = new TreeSet<>(Comparator.comparingInt(String::length)
                .thenComparing(String::compareTo));
        try (Scanner scanner = new Scanner(Path.of(PATH))) {
            while (scanner.hasNextLine()) {
                distinctWords.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return distinctWords;
    }

    // TASK 3
    private static Map<String, Integer> countRepetitions() {
        Map<String, Integer> wordsToRepetitions = new HashMap<>();
        try (Scanner scanner = new Scanner(Path.of(PATH))) {
            while (scanner.hasNextLine()) {
                wordsToRepetitions.merge(scanner.nextLine(), 1, Integer::sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordsToRepetitions;
    }

    // TASK 4
    private static Deque<String> reverseOrderLines() {
        Deque<String> stackLines = new ArrayDeque<>();
        try (Scanner scanner = new Scanner(Path.of(PATH))) {
            while (scanner.hasNextLine()) {
                stackLines.push(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stackLines;
    }

    // TASK 5
    private static <E> Iterator<E> reverseIterator(List<E> list) {
        return new Iterator<>() {
            int currentPosition = list.size();

            @Override
            public boolean hasNext() {
                return currentPosition > 0;
            }

            @Override
            public E next() {
                currentPosition--;
                return list.get(currentPosition);
            }
        };
    }

    // TASK 6
    private static List<String> linesByNumbers(int... nums) {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(Path.of(PATH))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> filteredLines = new ArrayList<>(nums.length);
        for (int i : nums) {
            filteredLines.add(lines.get(i - 1));
        }
        return filteredLines;
    }
}
