/**
 * Generic version of the Node class.
 *
 * @param <T> the type of the value
 */

public class Node<T> {
    T info;
    Node<T> nextNode;

    public Node() {

    }

    /**
     * Constructor with info and next node
     *
     * @param info     The info of this node
     * @param nextNode The next Node of this node
     */

    public Node(T info, Node nextNode) {
        this.info = info;
        this.nextNode = nextNode;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Convert this Note to String.
     */

    @Override
    public String toString() {
//        return "\n" + info;
        return String.valueOf(info);
    }

}


