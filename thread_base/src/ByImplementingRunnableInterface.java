public class ByImplementingRunnableInterface {
    public static void main(String[] args) {
        /*
         * 1. Define a class to implement Runnable interface
         * 2. Override run methods in the class 'MythreadByInterface'
         * But no return value
         */
        MythreadByRunnable mi = new MythreadByRunnable();
        Thread t1 = new Thread(mi,"m1");
        Thread t2 = new Thread(mi,"m2");
        t1.start();
        t2.start();

    }

}
