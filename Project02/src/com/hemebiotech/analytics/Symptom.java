package com.hemebiotech.analytics;

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

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setOccurrence(Integer occurrence) {
        this.occurrence = occurrence;
    }
}
