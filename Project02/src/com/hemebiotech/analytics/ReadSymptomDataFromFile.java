package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		
		if (filepath != null) {
			try (FileReader fileReader = new FileReader(filepath, StandardCharsets.UTF_8);
				 BufferedReader reader = new BufferedReader (fileReader);) {
				/*Alternatives to FileReader
				new BufferedReader (new InputStreamReader(new FileInputStream("symptoms.txt"), StandardCharsets.UTF_8));
				Files.newBufferedReader(Paths.get("symptoms.txt"), StandardCharsets.UTF_8);*/
				String line = reader.readLine();

				int i = 0;
				while (line != null) {
					i++;
					System.out.println(i +": symptom from file: " + line);
					result.add(line);
					line = reader.readLine();	// get another symptom
				}
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
				//System.out.println(e); //more synthetic message
			}
			catch (java.io.IOException e){
				e.printStackTrace();
				//System.out.println(e); //more synthetic message
			}
		}
		
		return result;
	}

}
