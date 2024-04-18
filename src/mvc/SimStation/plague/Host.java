package mvc.SimStation.plague;


import mvc.SimStation.Agent;
import mvc.SimStation.Heading;
import mvc.Utilities;

public class Host extends Agent {
    public PlagueSimulation world;
    public boolean infected = false;
    public boolean immune = false;
//    public boolean running = false;
    public int FRAME_HEIGHT = 400;
    public int FRAME_WIDTH = 400;

    public Host() {
        if (d100() <= world.RESISTANCE) {
            immune = true;
        }
        if (!immune && d100() <= world.INFECTED) {
            infected = true;
        }
        xc = Utilities.rng.nextInt(10, FRAME_WIDTH - 10);
        yc = Utilities.rng.nextInt(10, FRAME_HEIGHT - 10);
    }
    // optional override to smooth the graphics a little
//    public void run() {
//        if(!running) {
//            running = true;
//            while (!stopped) {
//                update();
//                world.notifySubscribers();
//                world.tick();
//            }
//        }
//    }
    @Override
    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(5) + 1;
        move(steps);
        Host p = (Host) world.getNeighbor(this, world.RANGE);
        if(p == null) {return;}
        if(!immune && p.infected) {
            if (d100() <= world.VIRULENCE) {
                infected = true;
            }
        }
    }

//    smoother animating move method

//    public void move(int steps) {
//        for (int i = 0; i < steps; i++) {
//            checkSuspended();
//            switch(heading) {
//                case NORTH: {
//                    yc++;
//                    break;
//                }
//                case SOUTH: {
//                    yc--;
//                    break;
//                }
//                case EAST: {
//                    xc++;
//                    break;
//                }
//                case WEST: {
//                    xc--;
//                    break;
//                }
//            }
//            yc = Math.floorMod(yc, FRAME_HEIGHT);
//            xc = Math.floorMod(xc, FRAME_WIDTH);
//            world.changed(); // Notify the world of the change in position
//            try{
//                Thread.sleep(20);
//            } catch(InterruptedException e) {
//                System.out.println(e);
//            }
//        }
//    }

    private int d100(){
        return (int) Math.ceil(Math.random() * 100);
    }
//
//    private synchronized void checkSuspended() {
//        try {
//            while(!stopped && suspended) {
//                wait();
//                suspended = false;
//            }
//        } catch (InterruptedException e) {
//            System.out.println(e);
//        }
//    }
}