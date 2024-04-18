package mvc.SimStation.plague;

import mvc.SimStation.Agent;
import mvc.Model;
import mvc.View;

import java.awt.*;

public class PlagueView extends View {
    public PlagueView(Model model) {
        super(model);
    }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        setBackground(Color.WHITE);
        PlagueSim plague = (PlagueSim) model;
        Color oldColor = gc.getColor();
        for (Agent a : plague.agents) {
            Peasant p = (Peasant) a;
            if (p.infected)
                gc.setColor(Color.RED);
            else
                gc.setColor(Color.GREEN);

            int r = 10;
            gc.fillOval(p.xc, p.yc, r, r);
        }
    }
}
