public class Player {
    int id;
    String name;

    public Player(String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return STR."Player{name='\{name}\{'\''}\{'}'}";
    }

    static class PlayerAverage {
        String name;
        double average;
        public PlayerAverage(String name, double average) {
            this.name = name;
            this.average = average;
        }
    }

}
