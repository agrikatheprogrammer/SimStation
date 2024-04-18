package mvc.SimStation.prisonersDilemma;

// each prisoner has fitness score
// prisoner update: prisoner plays game with random neighbor

import mvc.*;
import mvc.SimStation.*;

public class Prisoner extends Agent {
    int fitness = 0;
    boolean partnerCheated = false;
    private final Strategy strategy;

    public Prisoner(Strategy strategy){
        super();
        heading = Heading.random();

        this.strategy = strategy;
    }
    public boolean cooperate(){
        return strategy.cooperate();
    }

    public synchronized boolean getPartnerHistory(){
        return partnerCheated;
    }

    public Strategy getStrategy(){
        return this.strategy;
    }
    public int getFitness(){
        return this.fitness;
    }

    @Override
    public void update(){
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps); // continue

        Prisoner opponent = (Prisoner) world.getNeighbor(this, 10);

        if (opponent != null) {
            boolean prisoner1Coop = this.getStrategy().cooperate();
            boolean prisoner2Coop = opponent.getStrategy().cooperate();
            partnerCheated = prisoner2Coop;

            if (prisoner1Coop && prisoner2Coop) { // true & true = both cooperate
                this.updateFitness(3);
                opponent.updateFitness(3);
            } else if (prisoner1Coop && !prisoner2Coop) { // true & false = opp cheated
                this.updateFitness(0);
                opponent.updateFitness(5);
            } else if (!prisoner1Coop && prisoner2Coop) { // false & true = curr cheated
                this.updateFitness(5);
                opponent.updateFitness(0);
            } else { // false & false = both cheated
                this.updateFitness(1);
                opponent.updateFitness(1);
            }
        }
    }

    public void updateFitness(int amt){
        fitness += amt;
    }
}
