package com.hemebiotech.analytics;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Map management
 */
public class Symptoms {

    /**
     * Sorted Map with no duplication
     * Map.of("Symptom Libelle", Symptom Object)
     */
    private Map<String, Symptom> sortedMap;

    /**
    * Need a List with all Symptoms (raw list with duplications)
    * @param symptoms List < Symptom >
    **/
    public Symptoms(List<Symptom> symptoms) {
        buildSymptomsSortedMap(symptoms);
    }

    public Map<String, Symptom> getMap() {
        return sortedMap;
    }

    /**
     * Build a sorted Map of symptom with number of occurrence and No duplication
     * Need a List with all Symptoms (raw list with duplication)
     *
     * @param symptoms List < Symptom >
     */
    private void buildSymptomsSortedMap(List<Symptom> symptoms){
        //https://www.concretepage.com/java/jdk-8/java-8-convert-list-to-map-using-collectors-tomap-example
        //https://mkyong.com/java8/java-8-convert-list-to-map
        //https://stackoverflow.com/questions/20363719/java-8-listv-into-mapk-v
        sortedMap = symptoms.stream()
                .collect(Collectors.toMap(
                        Symptom::getLibelle,
                        v -> v,
                        (e1, e2) ->  new Symptom(e1.getLibelle(), e1.getOccurrence() + e2.getOccurrence()),
                        TreeMap::new)
                );
        //toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, Supplier mapSupplier)
        //TreeMap Methods: descendingMap, headMap, tailMap, subMap
    }

}
