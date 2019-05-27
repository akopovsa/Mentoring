package linkedListTests;

import module6.linked_list.LinkedList;
import org.junit.BeforeClass;

public class LinkedListRemoveTests {

    private static LinkedList linkedListInt;
    private static LinkedList linkedListString;

    @BeforeClass
    public static void createEmptyLinkedList(){
        linkedListInt = new LinkedList();
        linkedListString = new LinkedList();
    }

}
