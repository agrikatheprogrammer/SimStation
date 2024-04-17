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
        for(int i = 0; i < 50; i++)
            addAgent(new Peasant());
    }
    public void start(){
        for(Agent a: agents) {
            a.start();
        }
        clock++;
    }

    public void suspend(){
        for(Agent a: agents){
            a.suspend();
        }
    }

    public void resume(){
        for(Agent a: agents){
            a.resume();
        }
    }

    public void stop(){
        for(Agent a: agents){
            a.stop();
        }
    }

    public void changed(){
        notifySubscribers();
    }
        public static void main(String[] args) {
            AppPanel panel = new SimPanel(new PlagueFactory());
            panel.display();
        }

    }
