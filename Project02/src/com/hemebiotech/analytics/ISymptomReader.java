package com.hemebiotech.analytics;

import java.util.List;

/**
 * <b>Anything that will read symptom data from a source</b>
 * <p>The important part is:</p>
 * <ul>
 *     <li>The return value from the operation, which is a list of symptom Object, that may contain many duplications</li>
 *     <li>The implementation does not need to order the list</li>
 * </ul>
 */
public interface ISymptomReader {
	/**
	 * <b>Read symptom data from a source</b>
	 * @return Raw listing of Symptoms Object obtained from a data source: duplications possible and probable
	 */
	List<Symptom> GetSymptoms ();
}
