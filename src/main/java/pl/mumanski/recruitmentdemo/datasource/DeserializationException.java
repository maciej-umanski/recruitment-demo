package pl.mumanski.recruitmentdemo.datasource;

class DeserializationException extends RuntimeException {
    public <T> DeserializationException(Class<T> tClass, String json) {
        super(String.format("Cannot deserialize to %s given json: %s", tClass.getSimpleName(), json));
    }
}
