public class MyList<T> {

    Node<T> head;
    Node<T> tail;


    /**
     * Default constructor
     */

    public MyList() {
        this.head = this.tail = null;
    }


    /**
     * Constructor with head and tail
     *
     * @param head Head node of this list
     * @param tail Tail node of this list
     */

    public MyList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Checking if this list is empty
     *
     * @return true if list is empty
     */

    public boolean isEmpty() {
        return (this.head == null);
    }


    /**
     * Returning the length of this list
     *
     * @return The length of this list
     */

    public int length() {
        int length = 0;
        Node<T> current = this.head;

        while (current != null) {
            length++;
            current = current.nextNode;
        }
        return length;
    }


    /**
     * Insert an item to the head & tail of this list
     *
     * @param item The item to be inserted
     */

    public void insertToHead(T item) {
        Node<T> newProduct = new Node<T>();
        newProduct.info = item;
        if (isEmpty()) {
            head = tail = newProduct;
        } else {
            newProduct.nextNode = head;
            this.head = newProduct;
        }
    }

    public void inserToTail(T item) {
        Node<T> newProduct = new Node<T>();
        newProduct.info = item;
        if (isEmpty()) {
            head = tail = newProduct;
        } else {
            tail.nextNode = newProduct;
//            newProduct.nextNode = tail;
            this.tail = newProduct;
        }
    }


    /**
     * Deleting the head & tail of this list
     */

    public void deleteTail() {

        if (isEmpty()) {
            System.out.println("This LinkedList is empty!");
        }

        Node<T> current = this.head;
        for (int i = 0; i < ( this.length() - 1) ; i++) {
            current = current.nextNode;
        }

        this.tail = current;
        current.nextNode = null;

    }

    public void deleteHead() {
        if (isEmpty()) {
            System.out.println("This LinkedList is empty!");
        }

        Node<T> current = this.head;

        current = current.nextNode;
        this.head = current;
    }


    /**
     * Searching and deleting an item from this list by comparing the ID of items
     *
     * @param item The item to be deleted
     */

    public void deleteElement(T item) {

        Node<T> current = this.head;
        Node<T> prevNode = null;
        int counter = 0;

        while (current!=null) {
            int size = length();
            if (current.info == item) {
                if (counter == 0) {
                    this.head = this.head.getNextNode();
                    current = this.head;
                    if (this.head == null) {
                        this.tail = null;
                        return;
                    }
                    continue;
                } else if (counter == size - 1) {
                    prevNode.setNextNode(null);
                    this.tail = prevNode;
                } else {
                    prevNode.setNextNode(current.getNextNode());
                    current = current.getNextNode();
                }
            } else
                counter++;
                prevNode = current;
                current = current.getNextNode();

        }
        }



        // ép kiểu product
//    if(current.next.infor() == item)
//    current.next = cureent.next.next là được

    /**
     * Swaping two nodes [firstNode] and [secondNode]
     *
     * @param firstNode
     * @param secondNode
     */

    public void swap(Node<T> firstNode, Node<T> secondNode) {
        T temp;
        temp = firstNode.info;
        firstNode.info = secondNode.info;
        secondNode.info = temp;
    }




    /**
     * Deleting all items in the list
     */

    public void clear() {
        this.head = this.tail = null;
    }

    public void showProductList() {
        Node oneProduct = this.head;
        System.out.printf("%-5s%-5s%-15s%-5s%-7s%-5s%s", "ID","|", "Product Name","|","QuanliTy", "|","Price\n");
        System.out.println("-------------------------------------------------");
        while (oneProduct != null) {
            System.out.println(oneProduct.info);
            oneProduct = oneProduct.nextNode;
        }
        System.out.println("-------------------------------------------------");
    }


    // Ham toString
    @Override
    public String toString() {
        String s = "";

        Node current = head;

        while (current != null) {
            s += current.toString();
            current = current.nextNode;
        }

        return s;

    }

}


