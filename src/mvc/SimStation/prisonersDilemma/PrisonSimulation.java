package mvc.SimStation.prisonersDilemma;

import mvc.SimStation.*;
import mvc.*;

public class PrisonSimulation extends Simulation {
        public void populate() {
            int strat;
            Prisoner prisoner;

            // creates 40 prisoners with 10 of each: cooperate, randomlyCooperate, cheat, tit4tat
            for(int i = 0; i < 40; i++){
                strat = i % 4;
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

                addAgent(prisoner);
            }
        }

        public static void main(String[] args) {
            AppPanel panel = new SimPanel(new PrisonerFactory());
            panel.display();
        }

    }
