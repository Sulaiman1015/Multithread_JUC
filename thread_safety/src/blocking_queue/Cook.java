package blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread{
    ArrayBlockingQueue<String> queue;

    public Cook(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                queue.put("Food");
                System.out.println("Cook made a bowl of food and put it on the table");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
