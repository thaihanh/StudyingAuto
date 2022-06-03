package exercise5;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scanner.nextInt();
        System.out.println("----------------------");

        if (n <= 0) {
            System.out.println("Please enter a positive integer number!");
        } else {
            System.out.println(ln2(n));
        }
    }
    private static double ln2(int n) {
        double sum = 0;
        for (int index = 1, product = 1 ; index <= n ; index++, product *= -1) {
            sum += (double) product / index;
        }
        return sum;
    }

}

