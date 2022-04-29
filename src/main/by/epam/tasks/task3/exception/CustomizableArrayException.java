package main.by.epam.tasks.task3.exception;

public class CustomizableArrayException extends Exception {

    public CustomizableArrayException() {
        super();
    }

    public CustomizableArrayException(String message) {
        super(message);
    }

    public CustomizableArrayException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomizableArrayException(Throwable cause) {
        super(cause);
    }
}
