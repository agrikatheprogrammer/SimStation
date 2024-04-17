package mvc.SimStation.plague;

import mvc.SimStation.SimFactory;
import mvc.Model;
import mvc.View;

import java.util.ArrayList;

public class PlagueFactory extends SimFactory {
    public Model makeModel() {
        return new Plague();
    }

    public View makeView(Model model) {
        return new PlagueView(model);
    }

    public String getTitle() {
    return "Plague Simulator";
    }

    public String[] getHelp() {
        ArrayList<String> help = new ArrayList<>();
        help.add("help!"); //TODO
        String[] helpArray = (String[]) help.toArray();
        return helpArray;
    }
}
