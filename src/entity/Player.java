/**
 * Player.java
 *
 * Represents a player in the game.
 * Stores player information including ID and name.
 *
 * @author Robert Tronhage
 * @contact robert.tronhage@iths.se
 * @date 2024-01-25
 */

package entity;

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
        return "entity.Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

}
