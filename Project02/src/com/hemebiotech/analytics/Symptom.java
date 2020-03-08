package com.hemebiotech.analytics;

/**
 * Immutable Symptom Model
 */
public class Symptom {
    private String libelle;

    private Integer occurrence;

    public Symptom(String libelle) {
        this.libelle = libelle;
        this.occurrence = 1;
    }

    public Symptom(String libelle, Integer occurrence) {
        this.libelle = libelle;
        this.occurrence = occurrence;
    }


    public String getLibelle() {
        return libelle;
    }

    public Integer getOccurrence() {
        return occurrence;
    }

}
