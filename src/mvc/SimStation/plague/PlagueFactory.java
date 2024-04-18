package mvc.SimStation.plague;

import mvc.SimStation.SimFactory;
import mvc.Model;
import mvc.View;

public class PlagueFactory extends SimFactory {
    public Model makeModel() {
        return new PlagueSimulation();
    }

    public View makeView(Model model) {
        return new PlagueView(model);
    }

    public String getTitle() {
    return "Plague Simulator";
    }

    public String[] getHelp() {
        String[] help = new String[6];
        help[0] = "Plague Simulator! Simulates a plague spreading throughout a population through close contact.";
        help[1] = "Start - begins the simulation";
        help[2] = "Suspend - pauses the simulation";
        help[3] = "Resume - continues a suspended simulation";
        help[4] = "Stop - permanently ends the current simulation, restart the app or load a saved simulation to start again.";
        help[5] = "Stats - displays the number of agents, the current percentage infected, and the elapsed time.";
        return help;
    }
}
