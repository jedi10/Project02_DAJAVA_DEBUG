package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>Simple brute force implementation of Interface ISymptomReader</b>
 * @see ISymptomReader
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	/**
	 * Input FileName used for file reading
	 */
	private String fileName;
	
	/**
	 * <b>Constructor</b>
	 * need a fileName
	 * @param fileName a filename with symptom strings in it, one per line
	 * @see ReadSymptomDataFromFile#fileName
	 */
	public ReadSymptomDataFromFile (String fileName) {
		this.fileName = fileName;
	}

	/**
	 * <b>Read symptom data from a source</b>
	 * <ul>
	 *     <li>If no data is available, return an empty List; </li>
	 *     <li>If fileName is null, console shows a Warning message (App will not crash)</li>
	 * </ul>
	 * @return Raw listing of Symptoms Object obtained from a data source: duplications possible and probable
	 */
	@Override
	public List<Symptom> GetSymptoms() {
		ArrayList<Symptom> result = new ArrayList<>();
		
		if (fileName != null) {
			try (FileReader fileReader = new FileReader(fileName, StandardCharsets.UTF_8);
				 BufferedReader reader = new BufferedReader (fileReader);) {
				/*Alternatives to FileReader
				new BufferedReader (new InputStreamReader(new FileInputStream("symptoms.txt"), StandardCharsets.UTF_8));
				Files.newBufferedReader(Paths.get("symptoms.txt"), StandardCharsets.UTF_8);*/
				String line = reader.readLine();

				int i = 0;
				while (line != null) {
					i++;
					System.out.println(i +": symptom from file: " + line);
					result.add(new Symptom(line));
					line = reader.readLine();	// get another symptom
				}
				if (result.isEmpty()){
					System.out.println("WARNING: Reader Class: Symptoms File doesn't have any symptoms inside");
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
		} else {
			System.out.println("WARNING: Reader Class: Symptoms FileName is null");
		}
		return result;
	}

}
