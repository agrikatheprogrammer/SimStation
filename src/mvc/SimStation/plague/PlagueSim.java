package mvc.SimStation.plague;

import mvc.SimStation.Agent;
import mvc.SimStation.SimPanel;
import mvc.SimStation.Simulation;
import mvc.AppPanel;

public class PlagueSim extends Simulation {
    int clock = 0;
    public static int INFECTED = 10;
    public static int VIRULENCE = 50;
    public static double RANGE = 10.0;
    public static int RESISTANCE = 2;

    public void populate() {
        for (int i = 0; i < 50; i++) {
            Peasant p = new Peasant();
            p.world = this;
            addAgent(p);
        }
    }
    public void start(){
        for(Agent a: agents) {
            a.start();
        }
        clock++;
    }

    public void changed(){
        notifySubscribers();
    }
        public static void main(String[] args) {
            AppPanel panel = new SimPanel(new PlagueFactory());
            panel.display();
        }

    }
