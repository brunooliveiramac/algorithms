import java.util.ArrayList;
import java.util.List;

public class ProductSum {

    public static int productSum(List<Object> array) {
        return productSum(1, 0, array);
    }

    private static int productSum(int multiplier, int sum, List<Object> array) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) instanceof Integer) {
                sum += (Integer) array.get(i);
            }
            if (array.get(i) instanceof ArrayList) {
                multiplier += 1;
                sum += multiplier * (productSum(multiplier, 0, (List<Object>) array.get(i)));
                multiplier = 1;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        ArrayList<Object> a = new ArrayList<Object>();
        ArrayList<Object> b = new ArrayList<Object>();

        b.add(7);
        b.add(-1);

        ArrayList<Object> c = new ArrayList<Object>();
        ArrayList<Object> d = new ArrayList<Object>();
        d.add(-13);
        d.add(8);

        c.add(6);
        c.add(d);
        c.add(4);

        a.add(5);
        a.add(2);
        a.add(b);
        a.add(3);
        a.add(c);


        System.out.println(productSum(a));
    }
}
