package mvc.SimStation;

import mvc.Command;
import mvc.Model;

import javax.swing.*;

public class StatsCommand extends Command {

    public StatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        JOptionPane.showMessageDialog(
                null,
                "# of agents: " + ((Simulation) model).agents.size(),
                "Number of Agents",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
