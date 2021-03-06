package com.sbt.homework.genericshw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
        return source.stream()
                .limit(size)
                .collect(Collectors.toList());
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        for (T t : c2) {
            removeFrom.remove(t);
        }
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        for (T t : c2) {
            if (!c1.contains(t)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T t : c2) {
            if (c1.contains(t)) {
                return true;
            }
        }
        return false;
    }

    public static <T> List<Comparable<T>> range(List<? extends Comparable<T>> list, T min, T max) {
        return list.stream()
                .filter(t -> t.compareTo(min) >= 0 && t.compareTo(max) <= 0)
                .collect(Collectors.toList());
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {
        return list.stream()
                .filter(t -> comparator.compare(t, min) >= 0 && comparator.compare(t, max) <= 0)
                .collect(Collectors.toList());
    }
}