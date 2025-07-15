package org.test;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> dummyMap = new LinkedHashMap<>();

        // 3. Add dummy elements using the put() method
        dummyMap.put("Apple", 10);
        dummyMap.put("Banana", 5);
        dummyMap.put("Orange", 8);
        dummyMap.put("Grape", 12);
        System.out.println(dummyMap);
        Map<String, Integer> dummyMap1 = new HashMap<>();

        // 3. Add dummy elements using the put() method
        dummyMap1.put("Apple", 10);
        dummyMap1.put("Banana", 5);
        dummyMap1.put("Orange", 8);
        dummyMap1.put("Grape", 12);
        System.out.println(dummyMap1);

        Map<String, Integer> sortedMap = dummyMap1.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println(sortedMap);

    }


}
