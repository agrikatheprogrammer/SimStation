package mvc.SimStation.prisonersDilemma;

import SimStation.SimFactory;
import mvc.*;

import java.util.ArrayList;

public class PrisonerFactory extends SimFactory {
    public Model makeModel() {
        return new PrisonSimulation();
    }

    public String getTitle() {
        return "Prisoner's Dilemma Tournament";
    }

    public String[] getHelp() {
        ArrayList<String> help = new ArrayList<>();
        help.add("Populate - creates prisoners and has them begin playing the Prisoner's Dilemma Tournament");
        help.add("Suspend - stops the movement of the prisoners");
        help.add("Resume - resumes the tournament");
        help.add("Stats - displayed the average fitness score for each strategy");
        String[] helpArray = (String[]) help.toArray();
        return helpArray;
    }
    public String about(){
        return "<Cool Group Name Here>'s Prisoner's Dilemma Tournament. Prisoners will wander around playing games with another prisoner where there are 4 strategies: Cooperate, Random, Cheat, Tit4Tat. Points earned depends on the choices made by both prisoners.";
    }

}
