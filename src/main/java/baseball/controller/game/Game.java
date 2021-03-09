package baseball.controller.game;

import java.util.Arrays;
import java.util.Scanner;

import baseball.domain.console.Console;
import baseball.domain.hitter.Hitter;
import baseball.domain.pitcher.Pitcher;
import baseball.domain.rule.Rule;

public class Game {

    private Hitter hitter;
    private Pitcher pitcher;
    private final Console console;

    public Game(Scanner scanner) {
        this.console = new Console(scanner);
    }

    public void start() {
        boolean resume = true;
        while (resume) {
            this.pitcher = new Pitcher();
            this.hitter = new Hitter();
            this.console.printGameStart();
            bat();
            resume = this.console.getResumeOption();
        }
    }

    private void bat() {
        do {
            System.out.println(Arrays.toString(pitcher.getPitchedNumbers()));
            this.hitter.hit(this.console.getInputNumbersAndParseToIntArray());
        } while (!Rule
            .judgeAndIsOver(this.pitcher.getPitchedNumbers(), this.hitter.getHitNumbers()));
    }
}
