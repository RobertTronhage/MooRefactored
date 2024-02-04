/**
 * IOTest.java
 * This class contains unit tests for mocking IO using Mockito
 *
 * @author Robert Tronhage
 * @contact robert.tronhage@iths.se
 * @date 2024-02-04
 */

package test;

import IO.IO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class IOTest {

    @Mock
    IO ioMock = Mockito.mock(IO.class);

    @Test
    void testYesNoWithTrueResponse() {
        ioMock.addString("yes");
        assertTrue(ioMock.yesNo("Do you want to continue?"));
    }

    @Test
    void testYesNoWithFalseResponse() {
        ioMock.addString("no");
        assertFalse(ioMock.yesNo("Do you want to continue?"));
    }

}