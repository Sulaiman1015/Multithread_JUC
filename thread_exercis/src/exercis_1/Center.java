package exercis_1;

public class Center {
    static int tickets = 1000;
    //static final Object obj = new Object();
    public static void main(String[] args) {

        Counter_1 c1 = new Counter_1();
        Counter_2 c2 = new Counter_2();
        c1.setName("C1");
        c2.setName("C2");
        c1.start();
        c2.start();
    }

}
