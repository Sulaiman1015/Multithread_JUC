package blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread {
    ArrayBlockingQueue<String> queue;

    public Foodie(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                String f = queue.take();
                System.out.println(f);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
