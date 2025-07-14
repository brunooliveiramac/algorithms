import java.util.Comparator;

public class Product implements Comparator {

    private String name;
    private Float price;

    public Product(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compare(Object o1, Object o2) {
        Product p1 = (Product) o1;
        Product p2 = (Product) o2;
        return p1.price.compareTo(p2.price);
    }
}
