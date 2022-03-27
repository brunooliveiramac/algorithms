import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SheepManagerFuture {


    private int counter = 0;

    private void incrementAndReport() {
        System.out.println((++counter) + " ");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService service = null;

        try {

            service = Executors.newFixedThreadPool(10);

            SheepManagerFuture sheepManager = new SheepManagerFuture();

            for (int i = 0; i < 10; i++) {
               Future<?> result = service.submit( () -> sheepManager.incrementAndReport());
               result.get(10, TimeUnit.SECONDS);
            }
        } finally {
            if (service != null) service.shutdown();
        }


    }

}
