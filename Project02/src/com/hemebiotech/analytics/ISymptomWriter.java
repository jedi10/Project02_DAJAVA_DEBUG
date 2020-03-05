package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Build symptoms file
 */
public interface ISymptomWriter {

    /**
     * Build a file with all symptoms occurrence
     * need a sorted Map of unique symptoms
     * if Map is empty, the file will be empty
     * if fileName or symptoms Map are null, console shows a Warning message(app will not crash)
     *
     * @param symptomMap Map<String, Symptom>
     */
    public void buildSymptomsFile(Map<String, Symptom> symptomMap);
}
