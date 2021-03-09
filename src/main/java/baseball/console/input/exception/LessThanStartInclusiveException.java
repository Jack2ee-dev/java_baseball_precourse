package baseball.console.input.exception;

import baseball.domain.rule.Rule;

public class LessThanStartInclusiveException extends ConsoleInputException {

    public LessThanStartInclusiveException(String gamerInput) {
        super(gamerInput + ", " + "0보다 큰 수 " + Rule.DIGIT + "자리를 입력해주세요.(1~9)");
    }
}
