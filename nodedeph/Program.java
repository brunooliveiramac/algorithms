import java.util.*;

class Program {

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        return -1;
    }


    public static void main(String[] args) {
        BinaryTree b1 = new BinaryTree(1);
        BinaryTree b2 = new BinaryTree(2);
        BinaryTree b3 = new BinaryTree(3);
        BinaryTree b4 = new BinaryTree(4);
        BinaryTree b5 = new BinaryTree(5);
        BinaryTree b6 = new BinaryTree(6);
        BinaryTree b7 = new BinaryTree(7);
        BinaryTree b8 = new BinaryTree(8);
        BinaryTree b9 = new BinaryTree(9);

        b1.left = b2
        b1.right = b3

        b2.left = b4
        b2.right = b5

        b3.left = b6
        b3.right = b7
    }
}
