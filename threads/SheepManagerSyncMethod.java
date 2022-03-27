import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

public class SheepManagerSyncMethod {


    private int counter = 0;

    private synchronized void incrementAndReport() {
       System.out.println((++counter) + " ");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService service = null;

        try {

            service = Executors.newFixedThreadPool(10);

            SheepManagerSyncMethod sheepManager = new SheepManagerSyncMethod();

            for (int i = 0; i < 10; i++) {
               service.submit( () -> sheepManager.incrementAndReport());
            }
        } finally {
            if (service != null) service.shutdown();
        }


    }

}
