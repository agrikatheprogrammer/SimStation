package mvc.SimStation.prisonersDilemma;

import mvc.SimStation.*;
import mvc.*;

public class PrisonSimulation extends Simulation {

    public static int PRISON_POPULATION = 40;

    public void populate() {
        int strat;
        Prisoner prisoner;

        // creates 40 prisoners with 10 of each: cooperate, randomlyCooperate, cheat, tit4tat
        for(int i = 0; i < PRISON_POPULATION; i++){
            strat = i % 4; // 4 strategies
            if(strat == 0){
                prisoner = new Prisoner(new Cooperate());
            }
            else if(strat == 1){
                prisoner = new Prisoner(new RandomlyCooperate());
            }
            else if(strat == 2){
                prisoner = new Prisoner(new Cheat());
            }
            else{
                prisoner = new Prisoner(new Tit4Tat());
            }
            prisoner.getStrategy().myPrisoner = prisoner;
            addAgent(prisoner);
        }
    }

    @Override
    public String getStats() {
        int totalCooperate = 0;
        int totalRandom = 0;
        int totalCheat = 0;
        int totalTit4Tat = 0;

        for (Agent agent : agents) {
            Prisoner prisoner = (Prisoner) agent;
            if (prisoner.getStrategy() instanceof Cooperate) {
                totalCooperate += prisoner.fitness;
            } else if (prisoner.getStrategy() instanceof RandomlyCooperate) {
                totalRandom += prisoner.fitness;
            } else if (prisoner.getStrategy() instanceof Cheat) {
                totalCheat += prisoner.fitness;
            } else { // tit4tat
                totalTit4Tat += prisoner.fitness;
            }
        }

        // I made prison population a variable that can be changed but this part is coded expecting a clean divide
        String avgCooperate = "Cooperate: " + totalCooperate / 10;
        String avgRandom = "Random: " + (totalRandom / 10);
        String avgCheat = "Cheat: " + (totalCheat / 10);
        String avgTit4Tat = "Tit4Tat: " + (totalTit4Tat / 10);

        return "Average Fitness Strategy Scores: \n" + avgCooperate + "\n" + avgRandom + "\n" + avgCheat + "\n" + avgTit4Tat;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimPanel(new PrisonerFactory());
        panel.display();
    }

}
