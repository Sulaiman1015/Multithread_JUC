import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomTreadPool {
    public static void main(String[] args) {
        // Define parameters for the thread pool
        int corePoolSize = 3; // Core pool size
        int maximumPoolSize = 6; // Maximum pool size
        long keepAliveTime = 5000; // Thread idle time
        int queueCapacity = 3; // Task queue capacity

        // Create a custom thread pool
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }
}
