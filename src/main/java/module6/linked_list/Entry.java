package module6.linked_list;

public class Entry {
    private Object element;
    private Entry next;

    public Object getElement() {

        return element.toString();
    }

    Entry getNext() {
        return next;
    }

    void setNext(Entry next) {
        this.next = next;
    }

    Entry(Object element)
    {
        this.element = element;
        this.next = null;
    }
}
