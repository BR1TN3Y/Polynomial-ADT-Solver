public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * Constructor for creating a Node with the data.
     * @param data
     * @author Britney
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Getter method for the data in the Node.
     * @return data
     * @author Britney
     */
    public T getData() {
        return data;
    }

    /**
     * Getter method for the next Node in the linked list.
     * @return reference to the next Node.
     * @author Britney
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Setter method for the reference for the next Node in the linked list.
     * @param next the reference to the next Node
     * @author Britney
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}

