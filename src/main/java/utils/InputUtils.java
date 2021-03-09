package utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import baseball.console.input.exception.ConsoleInputException;
import baseball.console.input.exception.DuplicatedInputException;
import baseball.console.input.exception.LessThanStartInclusiveException;
import baseball.console.input.exception.NotParsableToIntException;
import baseball.console.input.exception.NotSelectableResumeOptionException;
import baseball.console.input.exception.OverflowOrUnderflowInputException;
import baseball.domain.rule.Rule;

public class InputUtils {

    private InputUtils() {
    }

    public static String validatedHitterNumbersInput(String numbersInput)
        throws ConsoleInputException {
        String sanitizedBlank = sanitizeBlank(numbersInput);
        validateInputDuplication(sanitizedBlank);
        validateInputIsParsableToInt(sanitizedBlank);
        validateInputLengthIsDigit(sanitizedBlank);
        validateInputMinimumConstraint(sanitizedBlank);

        return sanitizedBlank;
    }

    public static void validateInputMinimumConstraint(String input) throws ConsoleInputException {
        if (isLessThanMinimum(input)) {
            throw new LessThanStartInclusiveException(input);
        }
    }

    public static void validateInputDuplication(String input) throws ConsoleInputException {
        if (isDuplicated(input)) {
            throw new DuplicatedInputException(input);
        }
    }

    public static void validateInputIsParsableToInt(String input) throws ConsoleInputException {
        if (isNotParsableToInt(input)) {
            throw new NotParsableToIntException(input);
        }
    }

    public static void validateInputLengthIsDigit(String input) throws ConsoleInputException {
        if (isOverflowOrUnderflow(input)) {
            throw new OverflowOrUnderflowInputException(input);
        }
    }

    public static String validatedHitterResumeInput(String resumeInput)
        throws ConsoleInputException {
        String sanitizedBlank = sanitizeBlank(resumeInput);
        if (isUnSelectableForResumeGame(sanitizedBlank)) {
            throw new NotSelectableResumeOptionException(sanitizedBlank);
        }

        return sanitizedBlank;
    }

    private static boolean isDuplicated(String input) {
        String[] splits = input.split(Rule.HITTER_INPUT_DELIMITER);
        Set<String> set = new HashSet<>(Arrays.asList(splits));
        return input.length() != set.size();
    }

    private static String sanitizeBlank(String input) {
        return input.replaceAll("\\s+", "");
    }

    private static boolean isNotParsableToInt(String input) {
        try {
            Integer.parseInt(input);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static boolean isOverflowOrUnderflow(String input) {
        return input.length() != Rule.DIGIT;
    }

    private static boolean isUnSelectableForResumeGame(String input) {
        for (String option : Rule.RESUME_OPTIONS) {
            if (option.equals(input)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLessThanMinimum(String input) {
        for (String number : input.split(Rule.HITTER_INPUT_DELIMITER)) {
            if (Integer.parseInt(number) < Rule.START_NUMBER) {
                return true;
            }
        }
        return false;
    }
}
