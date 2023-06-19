package mephi.summerexam;

/**
 *
 * @author mrsot
 */
public class Sluice extends Reservoir{
    private boolean down;

    public Sluice(double length) {
        super(length);
        this.down = false;
    }
    public boolean isDown() {
        return down;
    }
    public void switchDown() {
        this.down = !down;
    }
    
    @Override
    public int getLengthInCycles(Ship ship) {
        int cyclesToPass = super.getLengthInCycles();
        if (ship.isDown() != this.isDown()) {
            return cyclesToPass + 13;
        } else {
            return cyclesToPass + 8;
        }
    }
}