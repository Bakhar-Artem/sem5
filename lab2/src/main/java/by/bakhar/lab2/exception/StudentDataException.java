package by.bakhar.lab2.exception;

public class StudentDataException extends Exception{
    public StudentDataException() {
    }

    public StudentDataException(String message) {
        super(message);
    }

    public StudentDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentDataException(Throwable cause) {
        super(cause);
    }
}
