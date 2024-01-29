package entity;

/*
 * Handle players average score.
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */
public class PlayerAverage {
    private String name;
    private double average;

    public PlayerAverage(String name, double average) {
        this.name = name;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}