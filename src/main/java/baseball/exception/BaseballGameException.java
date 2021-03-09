package baseball.exception;

public class BaseballGameException extends RuntimeException {

    public BaseballGameException(String message) {
        super("[ERROR] " + message);
    }
}
