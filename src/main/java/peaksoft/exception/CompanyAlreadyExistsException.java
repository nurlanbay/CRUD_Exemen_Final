package peaksoft.exception;

public class CompanyAlreadyExistsException extends RuntimeException {
    public CompanyAlreadyExistsException() {
    }

    public CompanyAlreadyExistsException(String message) {
        super(message);
    }
}
