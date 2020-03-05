package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WriteSymptomDataFile implements ISymptomWriter {

    private String fileName;

    /**
     * need a fileName for file creation
     * @param fileName file name
     */
    public WriteSymptomDataFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void buildSymptomsFile(Map<String, Integer> symptomMap) {
        try (FileWriter writer = new FileWriter(this.fileName);) {
            //writer.write("number of symptoms: " + AnalyticsCounter.map.size() + "\n");
            //writer.write("**************************\n");
            symptomMap.forEach((k, v) ->
                    {
                        try {
                            writer.write(k + ": " + v + "\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
