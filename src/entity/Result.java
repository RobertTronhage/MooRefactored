/**
 * Result.java
 *
 * Represents the result of a game, including the player's ID and result.
 *
 * @author Robert Tronhage
 * @contact robert.tronhage@iths.se
 * @date 2024-01-25
 */

package entity;

public class Result {

    int id;
    int playerid;
    int result;

    public Result(int playerid, int result) {
        this.playerid = playerid;
        this.result = result;
    }

    public int getPlayerid() {
        return playerid;
    }

    public void setPlayerid(int playerid) {
        this.playerid = playerid;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
