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
    private Reservoir reservoir1;
    private Reservoir reservoir2;
    private ArrayList<String> passedSluicesBy1 = new ArrayList<>();
    private ArrayList<String> passedSluicesBy2 = new ArrayList<>();

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
    public ArrayList<String> getPassedSluicesBy1() {
        return passedSluicesBy1;
    }
    public ArrayList<String> getPassedSluicesBy2() {
        return passedSluicesBy2;
    }
    public int getClockCycleHere1() {
        return clockCycleHere1;
    }
    public int getClockCycleHere2() {
        return clockCycleHere2;
    }
    public void setClockCycleHere1(int clockCycleHere1) {
        this.clockCycleHere1 = clockCycleHere1;
    }
    public void setClockCycleHere2(int clockCycleHere2) {
        this.clockCycleHere2 = clockCycleHere2;
    }
    public void decrementClockCycleHere1() {
        this.clockCycleHere1 -= 1;
    }
    public void setReservoir1(Reservoir reservoir1) {
        this.reservoir1 = reservoir1;
    }
    public void setReservoir2(Reservoir reservoir2) {
        this.reservoir2 = reservoir2;
    }
    
    public boolean check(JButton jButton, Ship ship){
        if (ship.isDown()) {
            if (reservoir2 == null) {
                if (jButton.getText().startsWith("Sluice")) {
                    reservoir2 = new Sluice(reservoires.get(jButton.getText()));
                } else {
                    reservoir2 = new Reservoir(reservoires.get(jButton.getText()));
                }
            }
            if (reservoir2 instanceof Sluice) {
                if (passedSluicesBy1.indexOf(jButton.getText()) > 0) {
                    ((Sluice) reservoir2).setDown(true);
                } else {
                    passedSluicesBy2.add(jButton.getText());
                }
            }
            int n = reservoir2.getLengthInCycles(ship);
            if (clockCycleHere2 < n) {
                clockCycleHere2 += 1;
                return true;
            } else {
                clockCycleHere2 = 0;
                reservoir2 = null;
                return false;
            }
        } else {
            if (reservoir1 == null) {
                if (jButton.getText().startsWith("Sluice")) {
                    reservoir1 = new Sluice(reservoires.get(jButton.getText()));
                } else {
                    reservoir1 = new Reservoir(reservoires.get(jButton.getText()));
                }
            }
            if (reservoir1 instanceof Sluice) {
                if (passedSluicesBy2.indexOf(jButton.getText()) > 0) {
                    ((Sluice) reservoir1).setDown(false);
                } else {
                    passedSluicesBy1.add(jButton.getText());
                }
            }
            int n = reservoir1.getLengthInCycles(ship);
            if (clockCycleHere1 < n) {
                clockCycleHere1 += 1;
                return true;
            } else {
                clockCycleHere1 = 0;
                reservoir1 = null;
                return false;
            }
        }
    }
}