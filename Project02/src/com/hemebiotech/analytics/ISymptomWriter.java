package com.hemebiotech.analytics;

import java.util.Map;

/**
 * <b>Build a file with multiples lines composed with unique symptom associate with occurrence</b>
 * <p>One line has two informations:</p>
 * <ul>
 *     <li>unique Symptom name</li>
 *     <li>Occurrence of the Symptom</li>
 * </ul>
 * @author jedi10
 */
public interface ISymptomWriter {

    /**
     * <b>Method build a file with unique symptom associate with occurrence</b>
     * Need a sorted Map of unique symptoms
     * @param symptomMap A Map With a String as a Key and Object Symptom as value
     */
    public void buildSymptomsFile(Map<String, Symptom> symptomMap);
}
