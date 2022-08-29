package pl.mumanski.recruitmentdemo.analysis;

class DomainValidationException extends RuntimeException {
    public DomainValidationException(String message) {
        super(message);
    }
}
