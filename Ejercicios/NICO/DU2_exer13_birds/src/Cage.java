import java.util.Random;

import static java.lang.Thread.sleep;

public class Cage {
    int eatingBirds = 0;
    boolean swingIsOccupied = false;
    private final Random rand = new Random();

    public synchronized void eat() throws InterruptedException {
        while (eatingBirds >= 3) {
            wait();
        }
        eatingBirds++;
        System.out.println(Thread.currentThread().getName() + " can start to eat");
    }

    public synchronized void stopEating() throws InterruptedException {
        sleep(rand.nextInt(501) + 500);
        System.out.println(Thread.currentThread().getName() + " stops eating");
        eatingBirds--;
        notifyAll();
    }

    public synchronized void swing() throws InterruptedException {
        while (swingIsOccupied) {
            wait();
        }
        swingIsOccupied = true;
        System.out.println(Thread.currentThread().getName() + " can start to swing");
    }

    public synchronized void stopSwinging() throws InterruptedException {
        sleep(rand.nextInt(1501) + 500);
        System.out.println(Thread.currentThread().getName() + " stops swinging");
        swingIsOccupied = false;
        notifyAll();
    }
}