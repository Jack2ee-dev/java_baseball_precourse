package console;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import baseball.console.input.ConsoleInput;
import baseball.console.input.exception.DuplicatedInputException;
import baseball.console.input.exception.NotParsableToIntException;
import baseball.console.input.exception.NotSelectableResumeOptionException;
import baseball.console.input.exception.OverflowOrUnderflowInputException;
import baseball.console.output.ConsoleOutput;
import utils.InputUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConsoleInputTest {

    private static final ConsoleInput input = new ConsoleInput(new Scanner(System.in));
    private static final ConsoleOutput output = ConsoleOutput.init();

    @Test
    void 숫자입력() {
        output.printInputNumbersSentence();
        String compared = input.getInputNumbersFromGamer();
        String comparing = "123";

        assertEquals(compared, comparing);
    }

    @Test
    void 중복숫자입력_예외발생() {
        assertThrows(DuplicatedInputException.class,
            () -> InputUtils.validateInputDuplication("111"));
    }

    @Test
    void Integer형으로_변환불가_예외발생() {
        assertThrows(NotParsableToIntException.class,
            () -> InputUtils.validateInputIsParsableToInt("11g"));
    }

    @Test
    void 게임재시작_옵션선택불가_예외발생()  {
        assertThrows(NotSelectableResumeOptionException.class,
            () -> InputUtils.validatedHitterNumbersInput("3"));
    }

    @Test
    void 유저입력_3자리가아닐경우_예외발생() {
        assertThrows(OverflowOrUnderflowInputException.class,
            () -> InputUtils.validateInputLengthIsDigit("3333"));
    }
}
