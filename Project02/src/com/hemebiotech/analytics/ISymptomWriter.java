package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Build symptoms file
 */
public interface ISymptomWriter {

    /**
     * Build a file with all symptoms occurrence
     * if no symptoms are given, the file will be empty
     * need a sorted map of unique symptoms
     * @param symptomMap Map<String, Integer>
     */
    public void buildSymptomsFile(Map<String, Integer> symptomMap);
}
