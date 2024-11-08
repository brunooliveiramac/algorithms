import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAndCallable {

    private static final ExecutorService pool = Executors.newFixedThreadPool(10);

    public static Callable<String> callable(String result, long sleepSeconds) {
        return () -> {
            Thread.sleep(sleepSeconds * 1000);
            System.out.printf("Thread %s finished%n", Thread.currentThread().getName());
            return "test - " + result;
        };
    }

    public static void main(String[] args) {
        try {
            Callable<String> callable1 = callable("result 1", 4);
            Callable<String> callable2 = callable("result 2", 1);
            Callable<String> callable3 = callable("result 3", 3);
            pool.submit(callable1);
            pool.submit(callable2);
            pool.submit(callable3);

            Future<String> f1 = pool.submit(callable1);
            while(!f1.isDone()) {
                System.out.println("Aguardando...");
            }
        } finally {
            pool.shutdown();
        }
    }

}
