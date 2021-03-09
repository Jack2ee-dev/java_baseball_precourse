package baseball.domain.hitter;

public class Hitter {

    private int[] hitNumbers;

    public Hitter() {
    }

    public void hit(int[] inputs) {
        this.hitNumbers = inputs;
    }

    public int[] getHitNumbers() {
        return this.hitNumbers;
    }
}
