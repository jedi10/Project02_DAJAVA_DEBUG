package com.hemebiotech.analytics;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnalyticsCounter {
	
	public static void main(String args[]) {
		//Read Input File
		String fileName = "symptoms.txt";
		ISymptomReader fileReader = new ReadSymptomDataFromFile(fileName);
		List<String> list = fileReader.GetSymptoms();
		// build sort Map
		Symptoms symptoms = new Symptoms(list);
		// Generate Output
		String outputFile = "result.out";
		ISymptomWriter fileWriter = new WriteSymptomDataFile(outputFile);
		fileWriter.buildSymptomsFile(symptoms.getMap());
	}
}
