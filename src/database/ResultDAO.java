package database;/*
 * Interface for handling result table in DB
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */

import IO.IO;

import java.sql.SQLException;

public interface ResultDAO {

    void saveResult(int nGuess, int playerId);

    void showTopTen(IO io);
}
