package baseball.domain.console;

import java.util.Scanner;

import baseball.console.input.ConsoleInput;
import baseball.console.input.exception.ConsoleInputException;
import baseball.console.output.ConsoleOutput;
import baseball.domain.rule.Rule;
import utils.InputUtils;

public class Console {

    private final ConsoleInput input;
    private final ConsoleOutput output;

    public Console(Scanner scanner) {
        this.input = new ConsoleInput(scanner);
        this.output = ConsoleOutput.init();
    }

    public int[] getInputNumbersAndParseToIntArray() {
        this.output.printInputNumbersSentence();
        return parseToIntArray(getInputNumbers());
    }

    public void printGameStart() {
        this.output.printGameStart();
    }

    private String getInputNumbers() {
        while (true) {
            String inputNumbersFromGamer = this.input.getInputNumbersFromGamer();
            try {
                return InputUtils.validatedHitterNumbersInput(inputNumbersFromGamer);
            } catch (ConsoleInputException e) {
                output.printError(e.getMessage());
            }
        }
    }

    private int[] parseToIntArray(String input) {
        int[] intArray = new int[input.length()];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Integer.parseInt(input.substring(i, i + 1));
        }
        return intArray;
    }

    public boolean getResumeOption() {
        while (true) {
            String inputResumeOption = this.input.getResumeOptionFromGamer();
            boolean resume = inputResumeOption.equals(Rule.RESUME);
            try {
                InputUtils.validatedHitterResumeInput(inputResumeOption);
                return resume;
            } catch (ConsoleInputException e) {
                output.printError(e.getMessage());
            }
        }
    }
}
