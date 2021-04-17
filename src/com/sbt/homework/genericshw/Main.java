package com.sbt.homework.genericshw;

import com.sbt.homework.genericshw.model.Animal;
import com.sbt.homework.genericshw.model.Cat;
import com.sbt.homework.genericshw.model.Dog;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        System.out.println("5 added " + map.getCount(5) + " times");
        System.out.println("6 added " + map.getCount(6) + " times");
        System.out.println("10 added " + map.getCount(10) + " times");
        System.out.println();

        System.out.println("Removing 10");
        map.remove(10);
        System.out.println("10 added " + map.getCount(10) + " times");
        System.out.println("CountMap size: " + map.size());
        System.out.println();

        System.out.println("Removing 10");
        map.remove(10);
        System.out.println("Removing 10");
        map.remove(10);
        System.out.println("10 added " + map.getCount(10) + " times");
        System.out.println("CountMap size: " + map.size());
        System.out.println();

        System.out.println("Adding elements from another map");
        CountMap<Integer> integerCountMap = new CountMapImpl<>();
        integerCountMap.add(88);
        integerCountMap.add(88);
        integerCountMap.add(88);
        integerCountMap.add(99);
        map.addAll(integerCountMap);
        System.out.println("88 added " + map.getCount(88) + " times");
        System.out.println("99 added " + map.getCount(99) + " times");
        System.out.println("CountMap size: " + map.size());
        System.out.println();

        System.out.println("Elements collected to map:");
        map.toMap().forEach((key, value) -> System.out.println("key = " + key + " value = " + value));
        System.out.println();

        System.out.println("Elements collected to destination map:");
        Map<Integer, Integer> destinationMap = new HashMap<>();
        map.toMap(destinationMap);
        destinationMap.forEach((key, value) -> System.out.println("key = " + key + " value = " + value));
        System.out.println();

        System.out.println("Testing CollectionUtils");
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Charlie"));
        dogs.add(new Dog("Oscar"));
        dogs.add(new Dog("Archie"));
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Bella"));
        cats.add(new Cat("Lucy"));
        cats.add(new Cat("Jack"));
        List<Animal> animals = new ArrayList<>();
        CollectionUtils.addAll(dogs, animals);
        CollectionUtils.addAll(cats, animals);

        animals.forEach(System.out::println);
        System.out.println();
        List<Animal> animals2 = CollectionUtils.newArrayList();
        CollectionUtils.addAll(animals, animals2);

        System.out.println("List produced by CollectionUtils");
        animals2.forEach(System.out::println);

        System.out.println("Index of Jack in animals: " + CollectionUtils.indexOf(animals, new Dog("Jack")));
        System.out.println("Index of Archie in dogs: " + CollectionUtils.indexOf(dogs, new Dog("Archie")));
        System.out.println();

        System.out.println("Animals list limited to 2: " + CollectionUtils.limit(animals, 2));

        System.out.println("Added new Cat Gary: ");
        CollectionUtils.add(animals, new Cat("Gary"));
        animals.forEach(System.out::println);
        System.out.println();

        System.out.println("Removing all dogs from animals: ");
        CollectionUtils.removeAll(animals, dogs);
        animals.forEach(System.out::println);
        System.out.println();

        System.out.print("Check if animals contains all cats: ");
        System.out.println(CollectionUtils.containsAll(animals, cats));
        System.out.println();

        System.out.print("Check if animals contains any dog: ");
        System.out.println(CollectionUtils.containsAny(animals, dogs));
        System.out.println();

        System.out.println("Animals with names from A to G by specified range: ");
        CollectionUtils.range(animals, new Animal("A"), new Animal("Gz"))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Animals with names length from 1 to 4 by specified range: ");
        CollectionUtils.range(animals, new Animal("A"), new Animal("AAAA"),
                Comparator.comparingInt(animal -> animal.getName().length()))
                .forEach(System.out::println);
    }
}
