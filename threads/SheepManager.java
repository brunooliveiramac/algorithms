import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManager {


    private int counter = 0;

    private void incrementAndReport() {
        System.out.println((++counter) + " ");
    }

    public static void main(String[] args) {

        ExecutorService service = null;

        try {

            service = Executors.newFixedThreadPool(20);

            SheepManager sheepManager = new SheepManager();

            for (int i = 0; i < 10; i++) {
                service.submit( () -> sheepManager.incrementAndReport());
            }
        } finally {
            if (service != null) service.shutdown();
        }


    }

}
