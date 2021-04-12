package com.sbt.homework.collectionshw.carstask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class CarListProcessor {

    public static Map<String, List<Car>> groupByType(List<Car> cars) {
        Map<String, List<Car>> groupedCars = new HashMap<>();
        for (Car car : cars) {
            groupedCars.merge(car.getType(), new ArrayList<>(List.of(car)), (cars1, cars2) -> {
                cars1.addAll(cars2);
                return cars1;
            });
        }
        return groupedCars;
    }

    public static Map<String, List<Car>> groupByTypeWithStream(List<Car> cars) {
        return cars.stream()
                .collect(Collectors.groupingBy(Car::getType));
    }
}
