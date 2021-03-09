package baseball.domain.rule;

import baseball.console.output.ConsoleOutput;

public class Rule {

    public static final int DIGIT = 3;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;
    public static final String HITTER_INPUT_DELIMITER = "";
    public static final String[] RESUME_OPTIONS = {"1", "2"};
    public static final String RESUME = "1";

    private Rule() {
    }

    public static boolean judgeAndIsOver(int[] pitch, int[] hit) {
        int strike = getStrikeCnt(pitch, hit);
        int ball = getBallCnt(pitch, hit);
        ConsoleOutput output = ConsoleOutput.init();
        output.printTrialResult(strike, ball);
        output.printGameOver(strike);
        return strike == DIGIT;
    }

    private static int getStrikeCnt(int[] pitch, int[] hit) {
        return strike(pitch, hit);
    }

    private static int getBallCnt(int[] pitch, int[] hit) {
        return ball(pitch, hit);
    }

    private static int strike(int[] pitch, int[] hit) {
        int cnt = 0;
        for (int i = 0; i < pitch.length; i++) {
            for (int j = 0; j < hit.length; j++) {
                if (isEqual(pitch[i], hit[j]) && isEqual(i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static int ball(int[] pitch, int[] hit) {
        int cnt = 0;
        for (int i = 0; i < pitch.length; i++) {
            for (int j = 0; j < hit.length; j++) {
                if (isEqual(pitch[i], hit[j]) && !isEqual(i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static boolean isEqual(int num1, int num2) {
        return num1 == num2;
    }
}
