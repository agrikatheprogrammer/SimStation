package mvc.SimStation.plague;

import mvc.Model;
import mvc.SimStation.Agent;
import mvc.SimStation.Simulation;
import mvc.View;

import java.awt.*;
import java.util.List;

public class PlagueView extends View {
    public PlagueView(Model model) {
        super(model);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Get the list of agents from the model
            List<Agent> agents = ((Simulation)model).agents;

            // Loop through each agent and draw it
            for (Agent agent : agents) {

                int x = agent.xc;
                int y = agent.yc;
                int screenWidth=getWidth();
                int screenHeight=getHeight();
                int MAX_X_COORDINATE=400;
                int MAX_Y_COORDINATE=400;
                double xScale = (double) screenWidth / MAX_X_COORDINATE; // MAX_X_COORDINATE is the maximum x coordinate value
                double yScale = (double) screenHeight / MAX_Y_COORDINATE; // MAX_Y_COORDINATE is the maximum y coordinate value

                // Scale the coordinates
                int scaledX = (int) (x * xScale);
                int scaledY = (int) (y * yScale);
                Host p = (Host) agent;
                if (p.infected)
                    g.setColor(Color.RED);
                else
                    g.setColor(Color.GREEN);
                // Draw a filled oval representing the agent
                g2d.fillOval(scaledX, scaledY, 10, 10);
            }
        }
/*
    This alternate view method will automatically scale the "playable area"
    in which agents can move to the current window size. Neat! But not exactly
    the functionality that the project calls for.

    @Override
    public void paintComponent(Graphics gc) {
        setPreferredSize(new Dimension(500,500));
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
                p.FRAME_HEIGHT = getVisibleRect().height;
                p.FRAME_WIDTH = getVisibleRect().width;
            int r = 10;
            gc.fillOval(p.xc, p.yc, r, r);
*/
}

