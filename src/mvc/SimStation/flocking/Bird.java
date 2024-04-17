package mvc.SimStation.flocking;

import mvc.SimStation.Agent;
import mvc.Utilities;

public class Bird extends Agent {
  int speed=5;

  public Bird() {
    super();
  }

  public void update(){
    int rand= Utilities.rng.nextInt(world.agents.size());
    Agent random=world.agents.get(rand);
    this.heading=random.heading;
    move(speed);
  }
}
