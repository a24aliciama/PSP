public class Main {
    public static void main(String[] args) {
        Cage cage = new Cage();
        for (int i = 1; i <= 10; i++) {
            Thread birdThread = new Thread(new Bird(cage), "Bird " + i);
            birdThread.start();
        }
    }
}