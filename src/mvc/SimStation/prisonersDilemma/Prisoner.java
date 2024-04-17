package mvc.SimStation.prisonersDilemma;

// each prisoner has fitness score
// prisoner update: prisoner plays game with random neighbor

import mvc.*;
import mvc.SimStation.*;

public class Prisoner extends Agent {
    private int fitness = 0;
    private boolean partnerCheated = false;
    private final Strategy strategy;

    public Prisoner(Strategy strategy){
        super();
        heading = Heading.random();

        this.strategy = strategy;
    }
    public boolean cooperate(){
        return strategy.cooperate();
    }

    public boolean getPartnerHistory(){
        return this.partnerCheated;
    }

    @Override
    public void update(){

        Prisoner opponent = (Prisoner) world.getNeighbor(this, 10.0);

        if (opponent != null) {
            boolean prisoner1Coop = this.cooperate();
            boolean prisoner2Coop = opponent.cooperate();
            partnerCheated = prisoner2Coop;

            if (prisoner1Coop && prisoner2Coop) { // true & true = both cooperate
                this.updateFitness(3);
                opponent.updateFitness(3);
            } else if (prisoner1Coop && !prisoner2Coop) { // true & false = opp cheated
                opponent.updateFitness(5);
            } else if (!prisoner1Coop && prisoner2Coop) { // false & true = curr cheated
                this.updateFitness(5);
            } else { // false & false = both cheated
                this.updateFitness(1);
                opponent.updateFitness(1);
            }
        }
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps); // continue
    }

    public void updateFitness(int amt){
        fitness += amt;
    }
}
