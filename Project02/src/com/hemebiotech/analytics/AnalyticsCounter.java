package com.hemebiotech.analytics;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnalyticsCounter {
	private static Map<String, Integer> map = new HashMap<>();
	private static Map <String, Integer> sortedMap = new TreeMap<>();

	public static void main(String args[]) {
		//Read Input File
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("symptoms.txt", StandardCharsets.UTF_8));
			String line = reader.readLine();
			int i = 0;
			while (line != null) {
				i++;
				System.out.println(i +": symptom from file: " + line);
				buildSymptomsMap(line);
				line = reader.readLine();// get another symptom
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//System.out.println(e); //more synthetic message
		} catch (java.io.IOException e){
			e.printStackTrace();
			//System.out.println(e); //more synthetic message
		} finally {
			if (reader != null){
				try {
					reader.close();
				}
				catch (IOException e)	{
					e.printStackTrace();
					//System.out.println(e); //more synthetic message
				}
			}
		}
		// Sort Map
		sortSymptomsMap();
		// Generate Output
		buildSymptomsFile();
	}

	/**
	 * Build Map of symptom with number of occurrence
	 * No doublon
	 * @param symptom
	 */
	private static void buildSymptomsMap(String symptom){
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
		var lambdaContext = new Object() {
			FileWriter writer = null;
		};
		try {
			lambdaContext.writer = new FileWriter("result.out");
			//writer.write("number of symptoms: " + AnalyticsCounter.map.size() + "\n");
			//writer.write("**************************\n");
			AnalyticsCounter.sortedMap.forEach((k, v) ->
					{
						try {
							lambdaContext.writer.write(k +": "+ v + "\n");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
			);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (lambdaContext.writer != null){
				try {
					lambdaContext.writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
