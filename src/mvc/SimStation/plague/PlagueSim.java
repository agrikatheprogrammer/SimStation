package mvc.SimStation.plague;

import mvc.SimStation.Agent;
import mvc.SimStation.SimPanel;
import mvc.SimStation.Simulation;
import mvc.AppPanel;

public class PlagueSim extends Simulation {
    int clock = 0;
    private static int AGENTS = 150;
    public static int INFECTED = 10;
    public static int VIRULENCE = 50;
    public static double RANGE = 10.0;
    public static int RESISTANCE = 2;




    public void populate() {
        for (int i = 0; i < AGENTS; i++) {
            Host p = new Host();
            p.world = this;
            addAgent(p);
        }
    }
    //This code makes "Stop" clear the simulation and allows "Start" to create a fresh one
    // if the simulation has been stopped.

//    private boolean stopped = false;
//    public void start(){
////        if(stopped){
////            populate();
////            stopped = false;
////        }
//        for(Agent a: agents) {
//            a.start();
//        }
//        clock++;
//    }

//    public void stop(){
//        for (Agent agent:agents) {
//            agent.stop();
//        }
////        agents.clear();
////        stopped = true;
//    }

    public Agent getNeighbor(Agent a, Double radius){
        boolean found = false;
        int i = (int) Math.floor(Math.random() * agents.size());
        int count = 0;
        while(!found) {
            i++;
            count++;
            if(i >= agents.size()) {i = 0;}
            int xDiff = a.xc - agents.get(i).xc;
            int yDiff = a.yc - agents.get(i).yc;
            double rad = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
            if(rad <= radius && !a.equals(agents.get(i))){ found = true; }
            if(count >= agents.size()) { return null; }
        }
        return agents.get(i);
    }


//    public void changed(){
//        setUnsavedChanges(true);
//        notifySubscribers();
//    }
        public static void main(String[] args) {
            AppPanel panel = new SimPanel(new PlagueFactory());
            panel.display();
        }

    }
