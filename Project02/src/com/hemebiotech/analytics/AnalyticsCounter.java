package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class AnalyticsCounter {
	private static Map<String, Integer> map = new HashMap<>();

	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	// set i to 0
		while (line != null) {
			i++;	// increment i
			System.out.println(i +": symptom from file: " + line);
			buildSymptomsMap(line);
			line = reader.readLine();// get another symptom
		}
		// next generate output
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
	 * Build symptoms file result.out
	 * @throws IOException
	 */
	private static void buildSymptomsFile() throws IOException {
		FileWriter writer = new FileWriter ("result.out");
		//writer.write("number of symptoms: " + AnalyticsCounter.map.size() + "\n");
		//writer.write("**************************\n");
		AnalyticsCounter.map.forEach((k, v) ->
				{
					try {
						writer.write(k +": "+ v + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		);
		writer.close();
	}
}
