package mvc.SimStation;

import mvc.Model;
import mvc.View;

import java.awt.*;
import java.util.List;

public class SimView extends View {
    public SimView(Model model) {
        super(model);
        setBackground(Color.MAGENTA);

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
            int MAX_X_COORDINATE=330;
            int MAX_Y_COORDINATE=380;
            double xScale = (double) screenWidth / MAX_X_COORDINATE; // MAX_X_COORDINATE is the maximum x coordinate value
            double yScale = (double) screenHeight / MAX_Y_COORDINATE; // MAX_Y_COORDINATE is the maximum y coordinate value

            // Scale the coordinates
            int scaledX = (int) (x * xScale);
            int scaledY = (int) (y * yScale);

            // Draw a filled oval representing the agent
            g2d.fillOval(scaledX, scaledY, 10, 10);
        }
    }
}
