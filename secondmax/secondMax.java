import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class secondMax {


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 8, 2, 33);
        System.out.println(secondMax(list));
    }


    public static Integer secondMax(List<Integer> list) {
//        Collections.sort(list);
//
//        Integer value = list.get(list.size() - 2);

        Integer aux = 0;
        Integer previousAux = 0;

        for (int i = 0; i < list.size(); i++) {
            Integer current = list.get(i);
            if (current > aux) {
                previousAux = aux;
                aux = current;
            }
        }
        return previousAux;
    }
}
