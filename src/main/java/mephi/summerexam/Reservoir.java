package mephi.summerexam;

/**
 *
 * @author mrsot
 */
public class Reservoir {
    private double length;

    public Reservoir(double length) {
        this.length = Math.ceil(length / 6 / 60 / 3);
    }
    public double getLength() {
        return length;
    }
}