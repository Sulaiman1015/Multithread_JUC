package base_demo;

public class SynchMethod implements Runnable {
    private static int ticket = 0;
    private static final int TOTAL_TICKETS = 20;
    private static final Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (toSync()) break;
            }
        }
    }

    private static boolean toSync() {
        if (ticket >= TOTAL_TICKETS) {
            return true;
        } else {
            ticket++;
            System.out.println(Thread.currentThread().getName() + " sold ticket n°" + ticket);
            if (ticket < TOTAL_TICKETS) {
                try {
                    lock.wait(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int threadsCount = 3; // Number of threads selling tickets
        for (int i = 1; i <= threadsCount; i++) {
            Thread t = new Thread(new SynchMethod(), "Counter-" + i);
            t.start();
        }
    }
}
