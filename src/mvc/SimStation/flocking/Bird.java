package mvc.SimStation.flocking;

import mvc.SimStation.Agent;
import mvc.Utilities;

public class Bird extends Agent {
  int speed;

  public Bird() {
    super();
    speed=Utilities.rng.nextInt(5)+1;
  }

  public void update(){
    Bird random=null;
    while (random==null) {
    random=(Bird) world.getNeighbor(this,10);}
    this.heading=random.heading;
    speed=random.speed;
    move(speed);
  }
}
