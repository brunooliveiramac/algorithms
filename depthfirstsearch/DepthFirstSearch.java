import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepthFirstSearch {

    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {

            if (name != null) {
                array.add(name);
            }

            for (int i = 0; i < children.size(); i++) {
                Node node = children.get(i);
                node.depthFirstSearch(array);
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void main(String[] args) {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");

        b.name = "B";
        c.name = "C";
        d.name = "D";

        e.name = "E";
        f.name = "F";

        a.name = "A";
        a.children = Arrays.asList(b, c, d);

        b.children = Arrays.asList(e, f);

        ArrayList<String> nodes = new ArrayList<>();

        System.out.println(a.depthFirstSearch(nodes));
    }

}
