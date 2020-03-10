package com.hemebiotech.analytics;

/**
 * <b>Immutable Symptom Model</b>
 * @author Jedy10
 */
public class Symptom {
    /**
     * symptom Name
     * @see Symptom#getLibelle()
     */
    private String libelle;

    /**
     * Occurrence Number
     * @see Symptom#getOccurrence()
     */
    private Integer occurrence;

    /**
     * <b>Constructor</b>
     * <p>Occurrence will be initialize to 1</p>
     * @param libelle symptom name
     * @see Symptom#libelle
     */
    public Symptom(String libelle) {
        this.libelle = libelle;
        this.occurrence = 1;
    }

    /**
     * <b>Constructor</b>
     * @param libelle symptom String
     * @param occurrence occurrence Number
     * @see Symptom#libelle
     * @see Symptom#occurrence
     */
    public Symptom(String libelle, Integer occurrence) {
        this.libelle = libelle;
        this.occurrence = occurrence;
    }

    /**
     * Get Symptom Name
     * @return Symptom name
     * @see Symptom#libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Get Symptom Occurrence
     * @return occurrence number
     * @see Symptom#occurrence
     */
    public Integer getOccurrence() {
        return occurrence;
    }

}
