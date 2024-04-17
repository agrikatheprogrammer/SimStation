package mvc.SimStation;

import mvc.Model;

import java.util.*;

public class Simulation extends Model {

    public Simulation(){
        populate();
    }
    public ArrayList<Agent> agents=new ArrayList<>();

        transient private Timer timer; // timers aren't serializable
        private int clock = 0;

        private void startTimer() {
            timer = new Timer();
            timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
        }

        private void stopTimer() {
            timer.cancel();
            timer.purge();
        }

        private class ClockUpdater extends TimerTask {
            public void run() {
                clock++;
            }
        }
    public void start(){
            for (Agent agent:agents) {
                agent.start();
            }
    }

    public void suspend(){
        for (Agent agent:agents) {
            agent.suspend();
        }
    }

    public void resume(){
        for (Agent agent:agents) {
            agent.resume();
        }
    }

    public void stop(){
        for (Agent agent:agents) {
            agent.stop();
        }
    }

    public Agent getNeighbor(Agent a, Double radius){
            return null;
    }

    public void addAgent(Agent agent){
            agents.add(agent);
            agent.setManager(this);
            notifySubscribers();
    }
    public void populate(){}
}
