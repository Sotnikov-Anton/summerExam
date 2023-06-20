package mephi.summerexam;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;

/**
 *
 * @author mrsot
 */
public class Executor {
    private HashMap<String, Double> reservoires = new HashMap<>();
    private int clockCycleHere1 = 0;
    private int clockCycleHere2 = 0;
    private Reservoir reservoir;
    private ArrayList<String> passedSluices = new ArrayList<>();

    public Executor() {
        reservoires.put("Channel 52", 0.86);
        reservoires.put("Sluice 1", 0.2683);
        reservoires.put("Channel 53", 1.05);
        reservoires.put("Ship's passage 54", 8.35);
        reservoires.put("Channel 55", 0.6);
        reservoires.put("Sluice 2", 0.268);
        reservoires.put("Channel 56", 0.6);
        reservoires.put("Ship's passage 57", 4.06);
        reservoires.put("Channel 58", 0.6);
        reservoires.put("Sluice 3", 0.2681);
        reservoires.put("Channel 59", 0.78);
        reservoires.put("Sluice 4", 0.2672);
        reservoires.put("Channel 60", 0.78);
        reservoires.put("Sluice 5", 0.2672);
        reservoires.put("Channel 61", 0.6);
        reservoires.put("Ship's passage 62", 4.38);
        reservoires.put("Channel 63", 0.79);
        reservoires.put("Sluice 6", 0.2633);
        reservoires.put("Channel 64", 0.85);
    }
    public ArrayList<String> getPassedSluices() {
        return passedSluices;
    }
    public int getClockCycleHere1() {
        return clockCycleHere1;
    }
    public int getClockCycleHere2() {
        return clockCycleHere2;
    }
    public void decrementClockCycleHere1() {
        this.clockCycleHere1 -= 1;
    }
    
    public boolean check(JButton jButton, Ship ship){
        if (reservoir == null) {
            if (jButton.getText().startsWith("Sluice")) {
                reservoir = new Sluice(reservoires.get(jButton.getText()));
            } else {
                reservoir = new Reservoir(reservoires.get(jButton.getText()));
            }
        }
        if (reservoir instanceof Sluice) {
            if (passedSluices.indexOf(jButton.getText()) > 0) {
                ((Sluice)reservoir).switchDown();
            } else {
                passedSluices.add(jButton.getText());
            }
        }
        int n = reservoir.getLengthInCycles(ship);
        if (ship.isDown()) {
            if (clockCycleHere2 < n) {
                clockCycleHere2 += 1;
                return true;
            } else {
                clockCycleHere2 = 0;
                reservoir = null;
                return false;
            }
        } else {
            if (clockCycleHere1 < n) {
                clockCycleHere1 += 1;
                return true;
            } else {
                clockCycleHere1 = 0;
                reservoir = null;
                return false;
            }
        }
    }
}