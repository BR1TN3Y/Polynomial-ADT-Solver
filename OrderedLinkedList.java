public class OrderedLinkedList <T extends Comparable<T>>{

    private Node<T> head;
    private int size;

    /**
     * Constructor
     */
    public OrderedLinkedList() {
        size=0;
        head=null;
    }

    /**
     * Function that inserts data into the linked list.
     * @param data
     */
    public void insert(T data){
        Node<T> new_node= new Node<>(data,null);
        Node<T> cur = head;
        Node<T> previous = null; // We want to know the previous node
        // locate the position we need.
        while (cur != null && data.compareTo(cur.getData()) < 0) {
            previous = cur;
            cur = cur.getNext();
        }

        if (cur==head) {
            // Insert at the beginning of the list
            new_node.setNext(head);
            head = new_node;
        } else {
            // Insert after the previous node
            previous.setNext(new_node);
            new_node.setNext(cur);
        }
        size++;
    }

    /**
     * Getter method of the index of current data.
     * @param index
     * @return the ith element in the list
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    /**
     * To get the size of the linked list.
     * @return size
     */
    public int getSize(){
        return size;
    }
}
