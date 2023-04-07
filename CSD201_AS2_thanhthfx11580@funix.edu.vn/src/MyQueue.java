
/**
 * Generic version of the Stack class.
 *
 * @param <T> the type of the value
 */

class MyQueue<T> {

    protected Node<T> front, rear;

    public MyQueue() {
        this.front = this.rear = null;
    }

    public boolean isEmpty() {
        return (this.front == null);
    }

    public void enqueue(T x) {
        if (isEmpty()) {
            this.front = this.rear = new Node<T>(x, null);
        } else {
            rear.nextNode = new Node<T>(x, null);
            rear = rear.nextNode;
        }
    }

    public T dequeue() throws Exception {
        if (isEmpty()) throw new Exception();

        T x = front.info;
        front=front.nextNode;
        if(front==null) rear=null;
        return(x);
    }

    public void showProductList() {
        Node current = this.front;
        System.out.printf("%-5s%-5s%-15s%-5s%-7s%-5s%s", "ID","|", "Product Name","|","QuanliTy", "|","Price\n");
        System.out.println("-------------------------------------------------");
        while (current != null) {
            System.out.println(current.info);
            current = current.nextNode;
        }
        System.out.println("-------------------------------------------------");
    }


}

