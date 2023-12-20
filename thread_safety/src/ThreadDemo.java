//public class ThreadDemo extends Thread {
//    /*
//     * the sale of 50 tickets totally across three ticket counters (guichets) using multiple threads
//     */
//    static int ticket = 0;
//    @Override
//    public void run() {
//        while (true){
//            synchronized (ThreadDemo.class){
//                if( ticket < 50 ){
////                    try {
////                        Thread.sleep(100);
////                    } catch (InterruptedException e) {
////                        throw new RuntimeException(e);
////                    }
//                    ticket++;
//                    System.out.println(getName()+" sold ticket n°"+ticket);
//                } else {
//                    break;
//                }
//            }
//        }
//    }
//}

//Runnable example
public class ThreadDemo implements Runnable {
    private static int ticket = 0;
    private static final Object lock = new Object();
    @Override
    public void run() {
        while (ticket < 50){
            synchronized (lock){
                if(ticket < 50){
                    ticket++;
                    System.out.println(Thread.currentThread().getName()+" sold ticket n°"+ticket);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
//        ThreadDemo t1 = new ThreadDemo();
//        t1.setName("t1");
//        ThreadDemo t2 = new ThreadDemo();
//        t2.setName("t2");
//        ThreadDemo t3 = new ThreadDemo();
//        t3.setName("t3");
//        t1.start();
//        t2.start();
//        t3.start();

        //Runnable example
        int counters = 3;
        for (int i = 1; i < counters; i++) {
            Thread t = new Thread (new ThreadDemo());
            t.start();
        }

    }
}
