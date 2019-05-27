package linkedListTests;

import module6.linked_list.LinkedList;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LinkedListAddStringTest {
    private static LinkedList linkedList;
    private static int i=0;

    @Parameterized.Parameter(0)
    public String e;


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { "A"}, { "B" }, { "C" } };
        return Arrays.asList(data);
    }


    @BeforeClass
    public static void createEmptyLinkedList(){
        linkedList = new LinkedList();
    }

    @Test
    public void addItemsToList(){
        linkedList.add(e);
        System.out.println(linkedList.get(i).toString());
        assertEquals(e,linkedList.get(i));
        i++;
    }

}
