import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        NodeDepth nodeDepth = new NodeDepth();
        MinimumWaitingTime minimumWaitingTime = new MinimumWaitingTime();

        ArrayList<Service> runs = new ArrayList<>();
        runs.add(nodeDepth);
        runs.add(minimumWaitingTime);

        runs.forEach(service -> service.execute());
    }


}
