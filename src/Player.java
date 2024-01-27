
/*
 * Player class
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */
public class Player {
    int id;
    String name;

    public Player(String name) {
        this(0,name);
    }

    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

}
