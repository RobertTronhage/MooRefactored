/**
 * PlayerAverage.java
 *
 * Represents the average result of a player in the game.
 * Used for displaying the top players with the lowest average guesses.
 *
 * @author Robert Tronhage
 * @contact robert.tronhage@iths.se
 * @date 2024-01-25
 */

package entity;
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

    @Override
    public String toString() {
        return "PlayerAverage{" +
                "name='" + name + '\'' +
                ", average=" + average +
                '}';
    }
}
