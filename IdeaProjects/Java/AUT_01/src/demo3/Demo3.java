package demo3;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i < n ; i += 2){
            {
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }
}
