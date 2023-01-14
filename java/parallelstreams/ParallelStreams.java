import java.util.Arrays;
import java.util.List;

public class ParallelStreams {

    public static void main(String[] args) {

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        Integer sum = listOfNumbers.parallelStream().reduce(5, Integer::sum);
        System.out.printf(sum.toString());

    }
}
