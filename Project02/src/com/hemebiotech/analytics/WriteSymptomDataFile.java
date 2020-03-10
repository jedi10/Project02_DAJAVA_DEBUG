package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * <b>Simple Implementation of Interface ISymptomWriter</b>
 * @see ISymptomWriter
 */
public class WriteSymptomDataFile implements ISymptomWriter {

    /**
     * Filename used for file creation
     */
    private String fileName;

    /**
     * <b>Constructor</b>
     * need a fileName
     * @param fileName file name
     * @see WriteSymptomDataFile#fileName
     */
    public WriteSymptomDataFile(String fileName) {
        this.fileName = fileName;
    }

    /**
     * <b>Method build a file with unique symptom associate with occurrence</b>
     * <p>Need a sorted Map of unique symptoms</p>
     * <ul>
     *     <li>If Map is empty, the generated file will be empty;</li>
     *     <li>If fileName or symptoms Map are null, console shows a Warning message(app will not crash)</li>
     * </ul>
     * @param symptomMap A Map With a String as a Key and Object Symptom as value
     */
    @Override
    public void buildSymptomsFile(Map<String, Symptom> symptomMap) {
        if (fileName != null) {
            if (symptomMap != null) {
                try (FileWriter writer = new FileWriter(this.fileName);) {
                    //writer.write("number of symptoms: " + AnalyticsCounter.map.size() + "\n");
                    //writer.write("**************************\n");
                    symptomMap.forEach((k, v) ->
                            {
                                try {
                                    writer.write(k + ": " + v.getOccurrence() + "\n");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    );
                    if (symptomMap.isEmpty()){
                        System.out.println("WARNING: Writer Class: Symptoms Map doesn't contain anything");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("WARNING: Writer Class: Symptoms Map is null");
            }
        } else {
            System.out.println("WARNING: Writer Class: Symptoms FileName is null");
        }
    }
}
