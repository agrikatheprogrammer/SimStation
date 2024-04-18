package mvc.SimStation.prisonersDilemma;

import mvc.*;

public abstract class Strategy {
    //myPrisoner --- strategy
    Prisoner myPrisoner;
    //idk whether to have myPrisoner as a component of Strategy since only Tit4Tat uses it
    /** public Strategy(Prisoner myPrisoner){
        this.myPrisoner = myPrisoner;
    } **/
    abstract boolean cooperate();
}


// cooperate, randomlyCooperate, cheat, tit4tat
class Cooperate extends Strategy{
    @Override
    public boolean cooperate(){
        return true; //always true
    }
}
class RandomlyCooperate extends Strategy{
    @Override
    public boolean cooperate(){
        return Utilities.rng.nextDouble() < 0.5; //either or
    }
}
class Cheat extends Strategy{
    @Override
    public boolean cooperate(){
        return false; //always false
    }
}
class Tit4Tat extends Strategy{
    /**public Tit4Tat(Prisoner myPrisoner){
        this.myPrisoner = myPrisoner;;
    } **/

    @Override
    public boolean cooperate(){
         return myPrisoner.partnerCheated;
    }
}
