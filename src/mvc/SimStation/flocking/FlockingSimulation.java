package mvc.SimStation.flocking;

import mvc.AppPanel;
import mvc.Model;
import mvc.SimStation.SimFactory;
import mvc.SimStation.SimPanel;
import mvc.SimStation.Simulation;


class FlockingFactory extends SimFactory {
    public Model makeModel() { return new FlockingSimulation(); }
    public String getTitle() { return "Flocking Birds";}



}

public class FlockingSimulation extends Simulation {


    public void populate() {
        for(int i = 0; i < 100; i++)
            addAgent(new Bird());
    }

    public static void main(String[] args) {
        AppPanel panel = new SimPanel(new FlockingFactory());
        panel.display();
    }

}
