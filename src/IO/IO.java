/**
 * IO.java
 * Interface defining methods for input/output operations.
 *
 * @author Robert Tronhage
 * @contact robert.tronhage@iths.se
 * @date 2024-01-25
 */

package IO;

public interface IO {
    boolean yesNo(String prompt);
    String getString();
    void addString(String s);
    void clear();
    void exit();
}
