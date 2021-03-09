package baseball.console.input.exception;

import baseball.domain.rule.Rule;
import baseball.exception.BaseballGameException;

public class NotParsableToIntException extends BaseballGameException {

    public NotParsableToIntException(String gamerInput) {
        super(gamerInput + ", " + Rule.DIGIT + "자리의 \'숫자\'를 입력해주세요.");
    }
}
