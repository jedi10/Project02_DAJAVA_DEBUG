package com.hemebiotech.analytics;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Symptoms {

    private Map<String, Integer> sortedMap = new TreeMap<>();

    /**
    * Need a List with all Symptoms (raw list with doublons)
    * @param symptoms List < String >
    **/
    public Symptoms(List<String> symptoms) {
        buildSymptomsSortedMap(symptoms);
    }

    public Map<String, Integer> getMap() {
        return sortedMap;
    }

    /**
     * Build a sorted Map of symptom with number of occurrence and No doublon
     * Need a List with all Symptoms (raw list with doublons)
     * @param symptoms List < String >
     */
    private void buildSymptomsSortedMap(List<String> symptoms){
        Map<String, Integer> map = new HashMap<>();
        map = buildSymptomsMap(symptoms);
        sortedMap = sortSymptomsMap(map);
    }

    /**
     * Build a Map of symptom with number of occurrence and No doublon
     * Need a List with all Symptoms (raw list with doublons)
     * @param symptoms List < String >
     */
    private Map<String, Integer> buildSymptomsMap(List<String> symptoms){
        Map<String, Integer> result = new HashMap<>();
        symptoms.forEach(symptom -> {
            Integer mapValue = null;
            Function<String, Integer> valueInit = v -> 1;
            BiFunction<String, Integer , Integer> valueCompute = (k, v) -> v + 1 ;

            mapValue = result.computeIfPresent(symptom, valueCompute);
            if (mapValue == null ){
                mapValue = result.computeIfAbsent(symptom, valueInit);
            }
            //Integer occurenceNumber = null;
            //occurenceNumber = map.putIfAbsent(symptom, 1);
            //map.put(symptom, map.get(symptom) + 1);
            //map.put(symptom, map.containsKey(symptom) ? map.get(symptom) + 1 : 1);
        });
        return result;
    }

    /**
     * Sort Symptoms Map and create a TreeMap
     */
    private Map<String, Integer> sortSymptomsMap(Map<String, Integer> map){
        Map<String, Integer> result = new TreeMap<>();
		/*Stream<Map.Entry<String,Integer>> sorted =
				map.entrySet().stream()
						.sorted(Map.Entry.comparingByValue());*/
        result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, TreeMap::new));
        //https://www.concretepage.com/java/jdk-8/java-8-convert-list-to-map-using-collectors-tomap-example
        //toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, Supplier mapSupplier)
        //TreeMap Methods: descendingMap, headMap, tailMap, subMap
        return result;
    }

}
