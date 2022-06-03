package exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a  = scanner.nextInt();
        System.out.print("Enter b: ");
        int b = scanner.nextInt();

        System.out.println("Sum a + b = " + sum(a,b));

    }
    public static int sum(int a, int b){
        return a + b;
    }
}