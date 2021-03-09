package baseball.console.input.exception;

import baseball.domain.rule.Rule;

public class OverflowOrUnderflowInputException extends ConsoleInputException {

    public OverflowOrUnderflowInputException(String userInput) {
        super(userInput + ", \'" + Rule.DIGIT + "\'자리의 수를 입력해주세요.");
    }
}
