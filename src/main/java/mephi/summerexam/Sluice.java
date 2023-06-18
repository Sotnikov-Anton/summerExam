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
    public void setDown(boolean down) {
        this.down = down;
    }
    
    
}