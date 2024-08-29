package training.threads;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        t1.start();
        t1.join(100);
        t2.start();

    }
}
