public class GoofyRunnable implements Runnable {

    private final int j;

    public GoofyRunnable(int j) {
        this.j = j;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from the Thread. " + i + "\n this is the j: " + j);

        }


    }

    public static void main(String args[]) {
        for (int i = 0; i < 500; i++) {
            Runnable r = new GoofyRunnable(i);
            r.run();
            System.out.println("This is Thread: " + i);
        }

    }


}
