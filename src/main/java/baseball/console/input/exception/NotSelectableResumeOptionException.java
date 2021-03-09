package baseball.console.input.exception;

import baseball.domain.rule.Rule;

public class NotSelectableResumeOptionException extends ConsoleInputException {

    public NotSelectableResumeOptionException(String gamerInput) {
        super(
            gamerInput + ", " + String.join("과 ", Rule.RESUME_OPTIONS) + " 중의 하나의 숫자를 입력하세요.");
    }
}
