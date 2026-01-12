package com.iut.collaborateurs.service;

public class PiechartData {
    private String label; // Nom du département
    private double percent; // Pourcentage

    public PiechartData() {}

    public PiechartData(String label, double percent) {
        this.label = label;
        this.percent = percent;
    }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    public double getPercent() { return percent; }
    public void setPercent(double percent) { this.percent = percent; }
}