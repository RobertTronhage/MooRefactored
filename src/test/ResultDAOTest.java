/**
 * ResultDAOTest.java
 * This class contains unit tests for mocking ResultDAO using Mockito
 *
 * @author Robert Tronhage
 * @contact robert.tronhage@iths.se
 * @date 2024-02-04
 */

package test;

import database.ResultDAO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import IO.IO;


class ResultDAOTest {

    @Mock
    IO ioMock = Mockito.mock(IO.class);
    @Mock
    ResultDAO resultDAOMock = Mockito.mock(ResultDAO.class);
    @Test
    void testSaveResult() {
        resultDAOMock.saveResult(5, 123);
        Mockito.verify(resultDAOMock, Mockito.times(1)).saveResult(5, 123);
    }

    @Test
    void testShowTopTen() {
        resultDAOMock.showTopTen(ioMock);
        Mockito.verify(resultDAOMock, Mockito.times(1)).showTopTen(ioMock);
    }
}