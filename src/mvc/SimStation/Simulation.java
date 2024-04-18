package mvc.SimStation;

import mvc.Model;
import mvc.Utilities;

import java.util.*;

public class Simulation extends Model {

    public Simulation(){
        populate();
    }
    public ArrayList<Agent> agents=new ArrayList<>();

        transient private Timer timer; // timers aren't serializable
        public int clock = 0;

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

    public Agent getNeighbor(Agent a, int radius) {
        int start = Utilities.rng.nextInt(agents.size());

        for(int i = 0; i < agents.size(); i++) {
            Agent current = agents.get((start + 1) % agents.size());

            if(distance(current, a) < radius) {
                return current;
            }
        }
        return null;
    }
    private double distance(Agent agent1, Agent agent2) {
        return Math.sqrt(Math.pow(agent1.xc-agent2.xc, 2) + Math.pow(agent1.yc - agent2.yc, 2));
    }
    public void addAgent(Agent agent){
            agents.add(agent);
            agent.setManager(this);
            notifySubscribers();
    }
    public void populate(){}

    public String getStats() {
            return "I am a simulation managing agents!";
    }
    public void tick(){
        clock++;
    }
}
