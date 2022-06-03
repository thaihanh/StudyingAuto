package main;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        //Main.display();
        //Main m = new Main(); // m is instance
        //m.sum(7,8);    // instance method

        //Scanner scanner = new Scanner(System.in);
        //String a = scanner.nextLine();

        Main x = new Main();
        int result = x.sum(4, 8);
        System.out.println(result);

        Main y = new Main();
        y.display(15);
    }
    public int sum(int a, int b){
        int result  = a + b;
        return result;
    }

    public void display(int a){
        System.out.println("a = " + a);
    }
}