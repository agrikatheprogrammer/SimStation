package mvc.SimStation.plague;


import mvc.SimStation.Agent;
import mvc.SimStation.Heading;
import mvc.Utilities;

public class Host extends Agent {
    public PlagueSim world;
    public boolean infected = false;
    public boolean immune = false;
    public boolean running = false;
    public int FRAME_HEIGHT = 400;
    public int FRAME_WIDTH = 400;

    public Host(){
        if(d100() <= world.RESISTANCE){
            immune = true;
        }
        if (!immune && d100() <= world.INFECTED) {
            infected = true;
        }
        xc = Utilities.rng.nextInt(10, FRAME_WIDTH - 10);
        yc = Utilities.rng.nextInt(10, FRAME_HEIGHT - 10);
    }
    public void run() {
        if(!running) {
            running = true;
            while (!stopped) {
                update();
                world.notifySubscribers();
            }
        }
    }
    @Override
    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(20) + 1;
        move(steps);
        Host p = (Host) world.getNeighbor(this, world.RANGE);
        if(p == null) {return;}
        if(!immune && p.infected) {
            if (d100() <= world.VIRULENCE) {
                infected = true;
            }
        }
    }
    @Override
    public void start(){
        myThread = new Thread(this);
        myThread.start();
    }
    public void suspend(){ suspended = true; }
    public void stop(){ stopped = true; }
    public void move(int steps) {
        for (int i = 0; i < steps; i++) {
            checkSuspended();
            switch(heading) {
                case NORTH: {
                    yc++;
                    break;
                }
                case SOUTH: {
                    yc--;
                    break;
                }
                case EAST: {
                    xc++;
                    break;
                }
                case WEST: {
                    xc--;
                    break;
                }
            }
            yc = Math.floorMod(yc, FRAME_HEIGHT);
            xc = Math.floorMod(xc, FRAME_WIDTH);
            world.changed(); // Notify the world of the change in position
            try{
                Thread.sleep(20);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    private int d100(){
        int roll = (int) Math.ceil(Math.random() * 100);
        return roll;
    }

    private synchronized void checkSuspended() {
        try {
            while(!stopped && suspended) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}