package producer_consumer;

public class Table {
    /*
     * Example wait and notify: producer_consumer.foodie -> desk <- cook, 10 bowls
     */

    public static int foodFlag = 0;

    public static int bowls = 10;

    public static final Object lock = new Object();

    public static void main(String[] args) {
        Foodie f = new Foodie();
        Cook c = new Cook();
        f.setName("Foodie");
        c.setName("Cook");
        f.start();
        c.start();
    }
}
