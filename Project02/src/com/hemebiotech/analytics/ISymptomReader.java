package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list of symptom Object,
 * that may contain many duplications
 * 
 * The implementation does not need to order the list
 * 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * if fileName is null, console shows a Warning message (App will not crash)
	 *
	 * @return List <Symptom> raw listing of all Symptoms Object obtained from a data source, duplications possible and probable
	 */
	List<Symptom> GetSymptoms ();
}
