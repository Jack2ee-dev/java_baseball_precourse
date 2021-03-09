package baseball.console.input.exception;

import baseball.exception.BaseballGameException;

public class ConsoleInputException extends BaseballGameException {

    public ConsoleInputException(String message) {
        super("입력값: " + message);
    }
}
