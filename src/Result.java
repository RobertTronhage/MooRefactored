/*
 * Result class
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */
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
