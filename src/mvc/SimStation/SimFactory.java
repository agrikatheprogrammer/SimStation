package mvc.SimStation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

import java.util.ArrayList;

public class SimFactory implements AppFactory {
    public Model makeModel() {
        return new Simulation();
    }

    public View makeView(Model model) {
        return new SimView(model);
    }

    public String getTitle() {
        return "SimStation";
    }

    public String[] getHelp() {
        ArrayList<String> help = new ArrayList<>();
        help.add("help!");
        String[] helpArray = (String[]) help.toArray();
        return helpArray;
    }

    public String about(){
        return "<Cool Group Name Here> Software 2024";
    }

    public String[] getEditCommands(){
        String[] commands = new String[5];
        commands[0] = "Start";
        commands[1] = "Suspend";
        commands[2] = "Resume";
        commands[3] = "Stop";
        commands[4] = "Stats";
        return commands;
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (searchEditCommand(type)){
            switch (type){
                case ("Start"):
                    StartCommand ra=new StartCommand(model);
                    return ra;
                case ("Suspend"):
                    SuspendCommand ra2=new SuspendCommand(model);
                    return ra2;
                case ("Resume"):
                    ResumeCommand populateCommand=new ResumeCommand(model);
                    return populateCommand;
                case ("Stop"):
                    return new StopCommand(model);
                case("Stats"):
                    return new StatsCommand(model);
            }
        }
        return null;
    }

    public boolean searchEditCommand(String type) {
        for (String a:getEditCommands()){
            if (a.equals(type)){
                return true;
            }
        }
        return false;
    }

}
