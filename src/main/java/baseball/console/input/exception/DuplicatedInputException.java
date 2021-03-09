package baseball.console.input.exception;

import baseball.domain.rule.Rule;

public class DuplicatedInputException extends ConsoleInputException {

    public DuplicatedInputException(String gamerInput) {
        super(gamerInput + ", \'서로 다른\' " + Rule.DIGIT + "자리의 수를 입력해주세요.");
    }
}
