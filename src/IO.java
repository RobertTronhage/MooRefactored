/*
 * Interface for user interface, input & output
 * Author: Robert Tronhage, robert.tronhage@iths.se
 * 2024-01-25
 */
public interface IO {
    boolean yesNo(String prompt);

    String getString();

    void addString(String s);

    void clear();

    void exit();
}
