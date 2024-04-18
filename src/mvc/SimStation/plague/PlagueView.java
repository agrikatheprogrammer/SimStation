package mvc.SimStation.plague;

import mvc.SimStation.Agent;
import mvc.Model;
import mvc.View;

import java.awt.*;

public class PlagueView extends View {
    public PlagueView(Model model) {
        super(model);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        PlagueSim plague = (PlagueSim) model;
        for(Agent a: plague.agents){
            Peasant p = (Peasant) a;
            if(p.infected){g.setColor(Color.RED);}
            else {g.setColor(Color.GREEN);}
            g.fillRect(p.xc, p.yc, 10, 10);
        }
    }
}
