import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AS2_Main {

    /**
     * Hàm main quản lý các chức năng
     **/

    public static void main(String[] args) throws Exception {

        OperationToProduct.setOutPrint();

        OperationToProduct Operation = new OperationToProduct();
        MyList<Product> myList = new MyList();
        MyStack<Product> myStack = new MyStack();
        MyQueue<Product> myQueue = new MyQueue();

        int choice = 0;

        do {
            Scanner sc = new Scanner(System.in);
            showMenu();
            System.out.print("choice:  ");
            choice = sc.nextInt();

            // Sử dụng SWITCH CASE để thực hiện từng chức năng.
            switch (choice) {

                case 0:
                    System.exit(0);
                    return;

                case 1:
                    System.out.println("1. Load data from file and display");
                    Operation.getAllItemsFromFile("D://Data.txt", myList);
                    Operation.displayAll(myList);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("2. Input & add to the end.");
                    Operation.addLast(myList);
                    break;

                case 3:
                    System.out.println("3. Display data");
                    Operation.displayAll(myList);
                    break;

                case 4:
                    System.out.println("4. Save product list to file.");
                    Operation.writeAllItemsToFile( myList,"D://Data.txt");
                    System.out.println("Complete !");
                    break;

                case 5:
                    System.out.println("5. Search by ID");
                    Operation.searchByCode(myList);
                    break;

                case 6:
                    System.out.println("6. Delete by ID");
                    Operation.deleteByCode(myList);
                    break;

                case 7:
                    System.out.println("7. Sort by ID.");
                    Operation.sortByCode(myList, myList.head);
                    Operation.displayAll(myList);
                    break;

                case 8:
                    System.out.println("8. Convert to Binary");
                    int binaryNum = Operation.convertToBinary(myList.head.info.quantity);
                    System.out.println("Quantity in binary: " + binaryNum);
                    break;

                case 9:
                    System.out.println("9. Load to stack and display");
                    Operation.getAllItemsFromFile("D://Data.txt", myStack);
                    Operation.displayAll(myStack);
                    break;

                case 10:
                    System.out.println("10. Load to queue and display.");
                    Operation.getAllItemsFromFile("D://Data.txt", myQueue);
                    Operation.displayAll(myQueue);
                    break;

            }


        } while (choice != 0);

    }

    /**
     * Hàm hiển thị menu chức năng cho người dùng lựa chọn.
     **/

    public static void showMenu() {

        System.out.println("Choose one of this options:");

        System.out.println("Product list:");

        System.out.println("1. Load data from file and display");

        System.out.println("2. Input & add to the end.");

        System.out.println("3. Display data");

        System.out.println("4. Save product list to file.");

        System.out.println("5. Search by ID");

        System.out.println("6. Delete by ID");

        System.out.println("7. Sort by ID.");

        System.out.println("8. Convert to Binary");

        System.out.println("9. Load to stack and display");

        System.out.println("10. Load to queue and display.");

        System.out.println("0. Exit");

    }

}
