package baseball.console.input;

import java.util.Scanner;

public class ConsoleInput {

    private final Scanner scanner;

    public ConsoleInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInputNumbersFromGamer() {
        return this.scanner.nextLine();
    }

    public String getResumeOptionFromGamer() {
        return this.scanner.nextLine();
    }
}
