package exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a floating-point number: ");
        double n = scanner.nextDouble();

        if (n * 1000 == 0) {
            System.out.println("zero");
        } else {
            if (n > 0) {
                if (Math.abs(n) < 1) {
                    System.out.println("small positive number");
                } else if (Math.abs(n) > 1000000) {
                    System.out.println("large positive number");
                } else {
                    System.out.println("positive number");
                }
            } else {
                if (Math.abs(n) < 1) {
                    System.out.println("small negative number");
                } else if (Math.abs(n) > 1000000) {
                    System.out.println("large negative number");
                } else {
                    System.out.println("negative number");
                }
            }
        }
    }
}
