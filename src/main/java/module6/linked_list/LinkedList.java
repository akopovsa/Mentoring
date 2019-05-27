package module6.linked_list;

public class LinkedList {
    private Entry head;
    private int count;

    public int getCount() {
        return count;
    }

    public LinkedList() {

    }

    public void add(Object entry) {

        if (head == null) {
            head = new Entry(entry);
        }

        Entry temp = new Entry(entry);
        Entry current = head;

        if(current!=null) {
            while (current.getNext() != null) {
                current = current.getNext();
            }
        }
        current.setNext(temp);
        count++;
    }

    public Object get(int index) {
        if (index < 0) {
            return null;
        }
        Entry current = null;
        if (head != null) {
            current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null) {
                    return null;
                }
                current = current.getNext();
            }
            if(current!=null){
                return current.getElement();
            }else{
                System.out.println("List is empty!");
            }
        }
        return current;

    }

    public void remove(int index) {

        if (index < 0 || index > getCount()){
            System.out.println("Index is out of range");
        }

        Entry current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            count--;
        }
    }


}
