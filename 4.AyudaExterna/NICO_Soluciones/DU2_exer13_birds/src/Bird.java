public class Bird implements Runnable{
    Cage cage;

    public Bird(Cage cage){
        this.cage = cage;
    }

    @Override
    public void run() {
        try {
            while (true) {
                cage.eat();
                cage.stopEating();
                cage.swing();
                cage.stopSwinging();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
