package com.sbt.homework.collectionshw.carstask;


import java.util.Objects;


public class Car {

    private final String model;
    private final String type;

    public Car(String model, String type) {
        this.model = model;
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(model, car.model) && Objects.equals(type, car.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, type);
    }

    @Override
    public String toString() {
        return "model='" + model + "', type='" + type + '\'';
    }
}
