package com.sbt.homework.collectionshw.carstask;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Лада", "седан"));
        cars.add(new Car("Лада", "хэтчбек"));
        cars.add(new Car("Лада", "кроссовер"));
        cars.add(new Car("Мерседес", "седан"));
        cars.add(new Car("Мерседес", "хэтчбек"));
        cars.add(new Car("Мерседес", "кроссовер"));
        cars.add(new Car("Бмв", "седан"));
        cars.add(new Car("Бмв", "хэтчбек"));
        cars.add(new Car("Бмв", "кроссовер"));
        cars.add(new Car("Форд", "седан"));
        cars.add(new Car("Форд", "хэтчбек"));
        cars.add(new Car("Форд", "кроссовер"));
        cars.add(new Car("Пежо", "седан"));
        cars.add(new Car("Пежо", "хэтчбек"));
        cars.add(new Car("Пежо", "кроссовер"));
        cars.add(new Car("Тойота", "седан"));
        cars.add(new Car("Тойота", "хэтчбек"));
        cars.add(new Car("Тойота", "кроссовер"));

        System.out.println("\n----------cars----------");
        cars.forEach(car -> System.out.println("car: " + car));

        System.out.println("\n-------grouped cars-----");
        CarListProcessor.groupByType(cars).forEach((type, groupedCars) -> {
            System.out.println(type + ":");
            groupedCars.forEach(car -> System.out.println("    car: " + car));
        });

        System.out.println("\n--alternatively grouped--");
        CarListProcessor.groupByTypeWithStream(cars).forEach((type, groupedCars) -> {
            System.out.println(type + ":");
            groupedCars.forEach(car -> System.out.println("    car: " + car));
        });
    }
}
