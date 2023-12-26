package blocking_queue;


import java.util.concurrent.ArrayBlockingQueue;

public class Table {
    /*
    * producer and consumer must using same blocking queue (ArrayBlockingQueue)
    * ArrayBlockingQueue has size
    **/
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        Foodie f = new Foodie(queue);
        Cook c = new Cook(queue);
        f.setName("Foodie");
        c.setName("Cook");
        f.start();
        c.start();
    }
}
