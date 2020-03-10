package com.hemebiotech.analytics;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <b>Map management</b>
 * @author Jedy10
 */
public class Symptoms {

    /**
     * <b>Sorted Map with no duplication</b>
     * <p>Map.of("Symptom Libelle", Symptom Object)</p>
     * @see Symptoms#getMap()
     */
    private Map<String, Symptom> sortedMap;

    /**
    * <b>Constructor</b>
    * <p>Need a List with all Symptoms (raw list with duplications)</p>
    * @param symptoms List of Symptom Object
    * @see Symptoms#sortedMap
    **/
    public Symptoms(List<Symptom> symptoms) {
        buildSymptomsSortedMap(symptoms);
    }

    /**
     * <b>Get a Sorted Map with no duplication</b>
     * @return Sorted Map with a Symptom Name as Key, Symptom Object as Value
     * @see Symptoms#sortedMap
     */
    public Map<String, Symptom> getMap() {
        return sortedMap;
    }

    /**
     * <b>Build a sorted Map of symptom with number of occurrence and No duplication</b>
     * <p>Need a List with all Symptoms (raw list with duplication)</p>
     *
     * @param symptoms List of Symptom Object
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
