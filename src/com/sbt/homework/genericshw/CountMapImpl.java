package com.sbt.homework.genericshw;

import java.util.HashMap;
import java.util.Map;


public class CountMapImpl<K> implements CountMap<K> {

    Map<K, Integer> cMap = new HashMap<>();

    @Override
    public void add(K key) {
        cMap.merge(key, 1, Integer::sum);
    }

    @Override
    public int getCount(K key) {
        return cMap.getOrDefault(key, 0);
    }

    @Override
    public int remove(K key) {
        if (cMap.remove(key, 1)) {
            return 1;
        } else if (!cMap.containsKey(key)) {
            return 0;
        }
        return cMap.merge(key, 1, (integer, integer2) -> --integer) + 1;
    }

    @Override
    public int size() {
        return cMap.size();
    }

    @Override
    public void addAll(CountMap<K> source) {
        source.toMap().forEach((key, sourceValue) -> cMap.merge(key, sourceValue, Integer::sum));
    }

    @Override
    public Map<K, Integer> toMap() {
        return cMap;
    }

    @Override
    public void toMap(Map<K, Integer> destination) {
        destination.clear();
        destination.putAll(cMap);
    }
}
