package za.co.bbd.mockito;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MockitoTest  {

    @Mock
    MyDatabase databaseMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testQuery() throws MyDatabase.DatabaseNotAvailableException {
        MyDatabase t = databaseMock;
        when(databaseMock.query("* from t"))
                .thenReturn(true);

        boolean check = t.query("* from t");
        assertTrue(check);

        verify(databaseMock).query("* from t");
    }

    @Test(expected = MyDatabase.DatabaseNotAvailableException.class)
    public void testQueryWhenDatabaseIsDown() throws MyDatabase.DatabaseNotAvailableException {
        MyDatabase t = databaseMock;
        when(databaseMock.query("* from t")).thenThrow(new MyDatabase.DatabaseNotAvailableException());
        boolean check = t.query("* from t");
    }
}