package baseball.console.output;

import baseball.domain.rule.Rule;

public class ConsoleOutput {

    private static final String RANDOM_NUMBERS_GENERATION_COMPLETE_MESSAGE = "임의의 3자리 수를 생성하였습니다. 숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBERS_SENTENCE = "숫자를 입력해주세요 : ";
    private static final String END_OF_GAME_SENTENCE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_TO_RESUME_SENTENCE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    private ConsoleOutput() {
    }

    public static ConsoleOutput init() {
        return new ConsoleOutput();
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void println(String message) {
        System.out.println(message);
    }

    public void printError(String errorMessage) {
        println(errorMessage);
    }

    public void printGameStart() {
        println(RANDOM_NUMBERS_GENERATION_COMPLETE_MESSAGE);
    }

    public void printInputNumbersSentence() {
        print(INPUT_NUMBERS_SENTENCE);
    }

    public void printTrialResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            println(NOTHING);
        }
        if (strike == 0 && ball != 0) {
            println(ball + BALL);
        }
        if (ball == 0 && strike != 0) {
            println(strike + STRIKE);
        }
        if (strike != 0 && ball != 0) {
            println(ball + BALL + " " + strike + STRIKE);
        }
    }

    public void printGameOver(int strike) {
        if (strike == Rule.DIGIT) {
            println(Rule.DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            printAskToResumeSentence();
        }
    }


    private void printAskToResumeSentence() {
        println(ASK_TO_RESUME_SENTENCE);
    }
}
