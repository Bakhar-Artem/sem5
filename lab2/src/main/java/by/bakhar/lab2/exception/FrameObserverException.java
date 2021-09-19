package by.bakhar.lab2.exception;

public class FrameObserverException extends Exception{
    public FrameObserverException() {
    }

    public FrameObserverException(String message) {
        super(message);
    }

    public FrameObserverException(String message, Throwable cause) {
        super(message, cause);
    }

    public FrameObserverException(Throwable cause) {
        super(cause);
    }
}
