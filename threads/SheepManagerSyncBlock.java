import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

public class SheepManagerSyncBlock {


    private int counter = 0;

    private void incrementAndReport() {
        synchronized (this) {
            System.out.println((++counter) + " ");
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService service = null;

        try {

            service = Executors.newFixedThreadPool(10);

            SheepManagerSyncBlock sheepManager = new SheepManagerSyncBlock();

            for (int i = 0; i < 10; i++) {
               service.submit( () -> sheepManager.incrementAndReport());
            }
        } finally {
            if (service != null) service.shutdown();
        }


    }

}
