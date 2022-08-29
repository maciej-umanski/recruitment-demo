package pl.mumanski.recruitmentdemo.datasource;

class DataAccessException extends RuntimeException {
    public DataAccessException(String error) {
        super("Could not access data from resources. Details: " + error);
    }
}
