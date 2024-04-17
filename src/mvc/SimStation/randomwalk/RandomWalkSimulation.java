package mvc.SimStation.randomwalk;

import mvc.*;
import mvc.SimStation.*;

class Drunk extends Agent {

    public Drunk() {
        super();
        heading = Heading.random();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

}


class RandomWalkFactory extends SimFactory {
    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}



}

public class RandomWalkSimulation extends Simulation {


    public void populate() {
        for(int i = 0; i < 15; i++)
            addAgent(new Drunk());
    }

    public static void main(String[] args) {
        AppPanel panel = new SimPanel(new RandomWalkFactory());
        panel.display();
    }

}


/* for (Agent agent:((Simulation)(panel.getModel())).agents) {
            System.out.println(agent.xc+" "+agent.yc);
            agent.setManager((Simulation)(panel.getModel()));
        }*/