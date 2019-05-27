package module6.linked_list;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList newLinkedList = new LinkedList();

        newLinkedList.add("A");
        System.out.println(newLinkedList.get(0));

        newLinkedList.add("B");
        System.out.println(newLinkedList.get(1));

        newLinkedList.add("C");
        System.out.println(newLinkedList.get(2));

        newLinkedList.remove(0);
        System.out.println(newLinkedList.get(0));

    }
}




