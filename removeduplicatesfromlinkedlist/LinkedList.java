public class LinkedList {

    // This is an input class. Do not edit.
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
        this.value = value;
        this.next = null;
    }


    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList current = linkedList;

        while (current != null) {
            LinkedList nextDistinct = current.next;
            while (nextDistinct != null && nextDistinct.value == current.value) {
                nextDistinct = nextDistinct.next;
            }
            current.next = nextDistinct;
            current = nextDistinct;
        }

        return linkedList;
    }


    public static void main(String[] args) {
        LinkedList e = new LinkedList(3);
        LinkedList d = new LinkedList(2);
        d.next = e;
        LinkedList c = new LinkedList(2);
        c.next = d;
        LinkedList b = new LinkedList(2);
        b.next = c;
        LinkedList a = new LinkedList(1);
        a.next = b;

        LinkedList linkedList = a.removeDuplicatesFromLinkedList(a);

        while (linkedList != null){
            System.out.println(linkedList.value);
            linkedList = linkedList.next;
        }
    }
}
