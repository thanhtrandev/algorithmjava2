import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperationToProduct {

    /**
     * Creating and returning a product with info input from keyboard.
     *
     * @return The product
     */

    public Product createProduct() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Id (in letter): ");
        String code = sc.next();

        System.out.print("Name (in letter): ");
        String title = sc.next();

        System.out.print("Quantity (in number): ");
        int quantity = sc.nextInt();

        System.out.print("Price (in number): ");
        double price = sc.nextInt();
        return new Product(code, title, quantity, price);

    }

    /**

     * Reading all products from the file and insert them to the list at tail.

     * @param fileName The file name of the file

     * @param list     The Linked List contains all products that read from file

     */

    public void getAllItemsFromFile(String fileName, MyList<Product> list) {
        String thisLine;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((thisLine = br.readLine()) != null) {
//                System.out.println(thisLine);
                String[] productInfo = thisLine.split("\\|");
                Product newProduct = new Product(productInfo[0].trim(), productInfo[1].trim(), Integer.parseInt(productInfo[2].trim()), Double.parseDouble(productInfo[3].trim()));
                list.inserToTail(newProduct);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");
        } catch (IOException ex) {
            System.out.println("Something wrong");
        }
    }

    /**
     * Reading all products from the file and insert them to the stack.
     *
     * @param fileName The file name of the file
     * @param stack    The Stack contains all products that read from file
     */

    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) {
        String thisLine;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((thisLine = br.readLine()) != null) {
//                System.out.println(thisLine);
                String[] productInfo = thisLine.split("\\|");
                Product newProduct = new Product(productInfo[0], productInfo[1], Integer.parseInt(productInfo[2].trim()), Double.parseDouble(productInfo[3].trim()));
                stack.push(newProduct);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");
        } catch (IOException ex) {
            System.out.println("Something wrong");
        }
    }


    /**
     * Reading all products from the file and insert them to the queue.
     *
     * @param fileName The file name of the file
     * @param queue    The Queue contains all products that read from file
     */

    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) {
        String thisLine;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(fileName));
            while ((thisLine = br.readLine()) != null) {
//                System.out.println(thisLine);
                String[] productInfo = thisLine.split("\\|");
                Product newProduct = new Product(productInfo[0], productInfo[1], Integer.parseInt(productInfo[2].trim()), Double.parseDouble(productInfo[3].trim()));
                queue.enqueue(newProduct);
            }
            br.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");
        } catch (IOException ex) {
            System.out.println("Something wrong");
        }
    }

    /**
     * Printing all prodcuts of the list, stack,queue to console screen
     */

    public void displayAll(MyList<Product> list) {
        list.showProductList();
    }

    public static void displayAll(MyStack<Product> stack) {
        stack.showProductList();
    }

    public static void displayAll(MyQueue<Product> queue) {
        queue.showProductList();
    }

    /**
     * Adding a product to the list, info of the product input from keyboard.
     *
     * @param list The Linked list
     */

    public void addLast(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        String isAnwer;

        do {
            list.inserToTail(createProduct());
            System.out.print("Continue (Y/N)?");
            isAnwer = sc.next();
        } while (isAnwer.equalsIgnoreCase("Y") || isAnwer.equalsIgnoreCase("yes"));

    }

    /**
     * Writing all products from the list to the file
     *
     * @param fileName Input file name
     * @param list     Input Linked list
     */

    public void writeAllItemsToFile(MyList<Product> list, String fileName) throws IOException {

        BufferedWriter br = new BufferedWriter(new FileWriter(fileName));
        Node current = list.head;

        while (current != null) {
            br.write(current.toString() + "\n");

            current = current.nextNode;

        }

        br.flush();
        br.close();
        System.out.println();
    }


    /**
     * Searching product by ID input from keyboard.
     *
     * @param list
     */
    public void searchByCode(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        Node<Product> current = list.head;
        System.out.print("Input the ID to search: ");
        String idSearch = sc.next();
        boolean isFound = false;

        while (current != null) {
            if (idSearch.equalsIgnoreCase(current.info.code)) {
                System.out.println("Product was found!");
                System.out.println(current.info);
                isFound = true;
                break;
            } else {
                current = current.nextNode;
            }
        }

        if (!isFound) {
            System.out.println("No product was found!");
        }

    }


    /**

     * Deleting product that has the ID input from keyboard from the list.

     * @param list

     */

    public void deleteByCode(MyList<Product> list) {
        Scanner input = new Scanner(System.in);
        Node<Product> browser = list.head;
        System.out.print("Delete Id: ");
        String searchKey = input.next();
        boolean isFound = false;
        while (browser != null) {
            if (searchKey.equalsIgnoreCase(browser.info.code)) {
                try {
                    list.deleteElement(browser.info);
                    System.out.println("Completed");
                    isFound = true;
                } catch (Exception ex) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            } else {
                browser = browser.nextNode;
            }
        }
        if (!isFound) {
            System.out.println("The ID is not in this list");
        }

    }


    /**

     * Sorting products in linked list by ID

     * @param list The Linked list

     */

    public void sortByCode(MyList<Product> list, Node<Product> start) throws Exception {
        if (list.isEmpty()) {
            throw new Exception();
        }
        if (start.nextNode == null) {
            return;
        }
        Node<Product> min = start.nextNode;
        while (min != null) {
            if (start.info.code.compareToIgnoreCase(min.info.code) > 0) {
                list.swap(start, min);
            }
            min = min.nextNode;
        }
        sortByCode(list, start.nextNode);
    }


    /**

     * Convert a decimal to a integer number. Example: input i = 18 -> Output = 10010

     * @param i Input decimal number

     * @return a integer numbers

     */

    public int convertToBinary(int i) {
        if (i == 0) {
            return 0;
        } else {
            return i % 2 + 10 * (convertToBinary(i / 2));
        }
    }

    /**
     * @description set the standard out to print on console and to file
     */

    public static void setOutPrint() {
        try {
            //create output streams writing to file
            FileOutputStream fout= new FileOutputStream("D://console_output.txt");

            //append all output stream to one stream
            MultiOutputStream multiOut= new MultiOutputStream(System.out, fout);

            //creat a print stream
            PrintStream stdout = new PrintStream(multiOut);

            //set the standard output
            System.setOut(stdout);

        } catch (FileNotFoundException ignored) {

        }
    }
}


