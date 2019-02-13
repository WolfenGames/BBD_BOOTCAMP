package za.co.bbd.mockito;

public class MyDatabase {

    public static class DatabaseNotAvailableException extends Exception {}

    public boolean query(String query) throws DatabaseNotAvailableException {
        throw new UnsupportedOperationException("Not yet Implemented");
//        return (false);
    }
}
