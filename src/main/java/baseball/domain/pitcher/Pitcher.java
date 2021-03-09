package baseball.domain.pitcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.domain.rule.Rule;
import utils.RandomUtils;

public class Pitcher {

    private final int[] pitchedNumbers = new int[Rule.DIGIT];

    public Pitcher() {
        generatePitchedNumbers();
    }

    private void generatePitchedNumbers() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < Rule.DIGIT) {
            set.add(RandomUtils.nextInt(Rule.START_NUMBER, Rule.END_NUMBER));
        }
        List<Integer> notDuplicatedNumbers = new ArrayList<>(set);
        for (int i = 0; i < Rule.DIGIT; i++) {
            this.pitchedNumbers[i] = notDuplicatedNumbers.get(i);
        }
    }

    public int[] getPitchedNumbers() {
        return this.pitchedNumbers;
    }
}
