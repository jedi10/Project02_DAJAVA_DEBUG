package com.hemebiotech.analytics;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Map management
 */
public class Symptoms {

    /**
     * Sorted Map with no duplication
     * Map.of("Symptom Libelle", Symptom Occurrence)
     */
    private Map<String, Integer> sortedMap;

    /**
    * Need a List with all Symptoms (raw list with duplications)
    * @param symptoms List < String >
    **/
    public Symptoms(List<String> symptoms) {
        buildSymptomsSortedMap(symptoms);
    }

    public Map<String, Integer> getMap() {
        return sortedMap;
    }

    /**
     * Build a sorted Map of symptom with number of occurrence and No duplication
     * Need a List with all Symptoms (raw list with duplication)
     * @param symptoms List < String >
     */
    private void buildSymptomsSortedMap(List<String> symptoms){
        //https://www.concretepage.com/java/jdk-8/java-8-convert-list-to-map-using-collectors-tomap-example
        //https://mkyong.com/java8/java-8-convert-list-to-map
        //https://stackoverflow.com/questions/20363719/java-8-listv-into-mapk-v
        sortedMap = symptoms.stream()
                .collect(Collectors.toMap(Function.identity(), s -> 1, Integer::sum, TreeMap::new));
        //toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, Supplier mapSupplier)
        //TreeMap Methods: descendingMap, headMap, tailMap, subMap
    }

}
