import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ByimplementingCallableInterface {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
         * 1. Define a class to implement callable interface
         * 2. Override run methods in the class 'MythreadByCallable'
         * Get a return value
         */

        MythreadByCallable ci = new MythreadByCallable();
        FutureTask<Integer> ft = new FutureTask<>(ci);

        Thread t = new Thread(ft,"ci");

        t.start();
        System.out.println(Thread.currentThread().getName()+" -> "+ft.get());

    }
}
