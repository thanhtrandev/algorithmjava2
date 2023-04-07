/**

 * Generic version of the Stack class.

 *

 * @param <T> the type of the value

 */

class MyStack<T> {

    MyList<T> list;

    public MyStack() {
        list = new MyList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }


    public void push(T info) {
        list.insertToHead(info);
    }

    public T top() {
         if(isEmpty()) return null;
            return list.head.info;
    }

    public T pop() {

        if (isEmpty()) {
            return null;
        }

        T info = list.head.info;
        list.deleteHead();

        return info;

    }

    public void showProductList() {
        Node browser = this.list.head;
        System.out.printf("%-5s%-5s%-15s%-5s%-7s%-5s%s", "ID","|", "Product Name","|","Quantity", "|","Price\n");
        System.out.println("-------------------------------------------------");
        while (browser != null) {
            System.out.println(browser.info);
            browser = browser.nextNode;
        }
        System.out.println("-------------------------------------------------");
    }



}

