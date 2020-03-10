package com.hemebiotech.analytics;

import java.util.*;

/**
 * <b>Main Class of the project</b>
 */
public class AnalyticsCounter {
	
	public static void main(String args[]) {
		//Read Input File
		String fileName = "symptoms.txt";
		ISymptomReader fileReader = new ReadSymptomDataFromFile(fileName);
		List<Symptom> list = fileReader.GetSymptoms();
		// build sort Map
		Symptoms symptoms = new Symptoms(list);
		// Generate Output
		String outputFile = "result.out";
		ISymptomWriter fileWriter = new WriteSymptomDataFile(outputFile);
		fileWriter.buildSymptomsFile(symptoms.getMap());
	}
}
