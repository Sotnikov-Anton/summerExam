package mephi.summerexam;

/**
 *
 * @author mrsot
 */
public class Reservoir {
    private int lengthInCycles;

    public Reservoir(double length) {
        this.lengthInCycles = (int)Math.ceil(length / 6 * 60 / 3);
    }
    public int getLengthInCycles() {
        return lengthInCycles;
    }
    public int getLengthInCycles(Ship ship) {
        return lengthInCycles;
    }
}