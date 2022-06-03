package exercise3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Util myStack = new Util(100);
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        do {
            System.out.println("==============================================");
            System.out.println("             Stack Operations Menu            ");
            System.out.println("==============================================");
            System.out.println("1. Add items");
            System.out.println("2. Delete items");
            System.out.println("3. Show the number of items");
            System.out.println("4. Show min and max items");
            System.out.println("5. Find an item");
            System.out.println("6. Print all items");
            System.out.println("7. Exit");

            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println("------------------------------");

            switch (choice) {
                case 1:
                    System.out.print("Enter element: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    myStack.push(n);
                    break;
                case 2:
                    System.out.println("Removed element" + myStack.pop());
                    break;
                case 3:
                    System.out.println("The number of items: " + myStack.size());
                    break;
                case 4:
                    System.out.println("Max is: " + myStack.max());
                    System.out.println("Min is: " + myStack.min());
                    break;
                case 5:
                    System.out.println("Enter element which you want search: ");
                    int searchElement = Integer.parseInt(scanner.nextLine());
                    if (myStack.search(searchElement) != (-1)){
                        System.out.println("Position of element: " + myStack.search(searchElement));
                    } else {
                        System.out.println("No result found");
                    }
                    break;
                case 6:
                    System.out.print("Print all items: ");
                    myStack.display();
                    break;
                case 7:
                    System.out.println("Close program successfully");
                    System.exit(1);
                    break;
                case 8:
                    flag = false;
                    break;
                default:
                    System.out.println("Only choose 1 - 7.");
            }
        } while (flag);
    }
}
