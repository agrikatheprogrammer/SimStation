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
      @Override
    public String getStats() {
        int[] array=new int[6];
        for (Agent agent: agents)
        {
            int s=((Bird)agent).speed;
            array[s]++;
        }
        String repeated="# of birds at speed ";
        return repeated+"1: "+array[1]+"\n"+
                repeated+"2: "+array[2]+"\n"+
                repeated+"3: "+array[3]+"\n"+
                repeated+"4: "+array[4]+"\n"+
                repeated+"5: "+array[5]+"\n";
    }


    public void populate() {
        for(int i = 0; i < 100; i++)
            addAgent(new Bird());
    }

    public static void main(String[] args) {
        AppPanel panel = new SimPanel(new FlockingFactory());
        panel.display();
    }

}
