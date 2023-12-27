import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MythreadPool {
    /*
     * public static ExecutorService newCachedTreadPool()
     * public static ExecutorService newFixedTreadPool(int nThread)
     */
    public static void main(String[] args) throws InterruptedException {
        // get thread pool obj
        ExecutorService pool1 = Executors.newCachedThreadPool();
        ExecutorService pool2 = Executors.newFixedThreadPool(2);

        //create task
        pool1.submit(new MyRunnable());
        pool1.shutdownNow();
        pool2.submit(new MyRunnable());
        pool2.shutdown();

    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            // Task logic goes here
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"--"+i);
            }
        }
    }
}
