package mvc.SimStation;

import mvc.Utilities;

import java.io.Serializable;

public abstract class Agent implements Serializable, Runnable {
    public Simulation world;
    public String name;
    public Heading heading;
    public int xc;
    public int yc;
    public boolean suspended;
    public boolean stopped;
    public transient Thread myThread;

    public Agent() {
     //   this.name = name;
        suspended = false;
        stopped = false;
        myThread = null;
        xc=Utilities.rng.nextInt(181)+50;
        yc=Utilities.rng.nextInt(231)+50;
    }

    public void setManager(Simulation m) { world = m; }

    public void start(){
        Thread thread=new Thread(this);
        thread.start();
    }


    public synchronized void stop() { stopped = true; }
    public synchronized boolean isStopped() { return stopped; }
    public synchronized void suspend() { suspended = true; }
    public synchronized boolean isSuspended() { return suspended;  }
    public synchronized void resume() { notify(); }
    private synchronized void checkSuspended() {
        try {
            while(!stopped && suspended) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


    public void run() {
        myThread = Thread.currentThread();
        while (!stopped) {
            try {
                update();
                Thread.sleep(20);
                world.notifySubscribers();
                checkSuspended();
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public abstract void update();

    public void move(int steps) {
        for (int i = 0; i < steps; i++) {
            if (heading == Heading.NORTH) {
                yc++;
            } else if (heading == Heading.SOUTH) {
                yc--;
            } else if (heading == Heading.EAST) {
                xc++;
            } else {
                xc--;
            }
            if (yc>380) {
                yc=10;
            }
            if (xc>330) {
                xc=10;
            }
            world.changed(); // Notify the world of the change in position
        }
    }



}
