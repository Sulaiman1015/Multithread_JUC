package base_demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo implements Runnable{

    private static int ticket = 0;
    private static final int TOTAL_TICKETS = 20;
    private static final Object obj = new Object();

    Lock lk = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lk.lock();
            if (toSync()) break;
            lk.unlock();
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
                    obj.wait(100);
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
