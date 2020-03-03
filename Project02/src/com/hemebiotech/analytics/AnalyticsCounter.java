package com.hemebiotech.analytics;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnalyticsCounter {
	private static Map<String, Integer> map = new HashMap<>();
	private static Map <String, Integer> sortedMap = new TreeMap<>();

	public static void main(String args[]) {
		//Read Input File
		String fileName = "symptoms.txt";
		ISymptomReader fileReader = new ReadSymptomDataFromFile(fileName);
		List<String> list = fileReader.GetSymptoms();
		// build Map
		buildSymptomsMap(list);
		// Sort Map
		sortSymptomsMap();
		// Generate Output
		buildSymptomsFile();
	}

	/**
	 * Build a Map of symptom with number of occurrence and No doublon
	 * Need a List with all Symptoms (raw list with doublons)
	 * @param symptoms List < String >
	 */
	private static void buildSymptomsMap(List<String> symptoms){
		symptoms.forEach(symptom -> {
			Integer mapValue = null;
			Function<String, Integer> valueInit = v -> 1;
			BiFunction<String, Integer , Integer> valueCompute = (k, v) -> v + 1 ;

			mapValue = AnalyticsCounter.map.computeIfPresent(symptom, valueCompute);
			if (mapValue == null ){
				mapValue = AnalyticsCounter.map.computeIfAbsent(symptom, valueInit);
			}
			//Integer occurenceNumber = null;
			//occurenceNumber = map.putIfAbsent(symptom, 1);
			//map.put(symptom, map.get(symptom) + 1);
			//map.put(symptom, map.containsKey(symptom) ? map.get(symptom) + 1 : 1);
		});
	}

	/**
	 * Sort Symptoms Map and create a TreeMap
	 */
	private static void sortSymptomsMap(){
		/*Stream<Map.Entry<String,Integer>> sorted =
				map.entrySet().stream()
						.sorted(Map.Entry.comparingByValue());*/
		AnalyticsCounter.sortedMap = map.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.naturalOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, TreeMap::new));
		//https://www.concretepage.com/java/jdk-8/java-8-convert-list-to-map-using-collectors-tomap-example
		//toMap(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, Supplier mapSupplier)
		//TreeMap Methods: descendingMap, headMap, tailMap, subMap
		AnalyticsCounter.map.clear();
	}

	/**
	 * Build symptoms file result.out
	 */
	private static void buildSymptomsFile() {
		String fileName = "result.out";
		try (FileWriter writer = new FileWriter(fileName);) {

			//writer.write("number of symptoms: " + AnalyticsCounter.map.size() + "\n");
			//writer.write("**************************\n");
			AnalyticsCounter.sortedMap.forEach((k, v) ->
					{
						try {
							writer.write(k +": "+ v + "\n");
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
