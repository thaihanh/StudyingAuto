package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckAssignment {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//     exercíe 1
        System.out.println("nhập số đầu tiên: ");
        int a = scanner.nextInt();
        System.out.println("nhập số thứ hai: ");
        int b = scanner.nextInt();
        System.out.println("Tổng 2 số là: " + Sum(a, b));

    // exercie 3
        System.out.println("nhập số nhị phân đầu tiên: ");
        String c = scanner.next();
        System.out.println("nhập số nhị phân thứ hai: ");
        String d = scanner.next();
        System.out.println("Tích 2 số nhị phân là: " + Binary(c, d));

    // exercise 4
        System.out.println("nhập số đầu tiên: ");
        int e = scanner.nextInt();
        System.out.println("nhập số thứ hai: ");
        int f = scanner.nextInt();
        System.out.println("Kết quả: " + Compare(e, f));

//     exercise 5
        System.out.println("nhập số đầu tiên: ");
        double meters = scanner.nextDouble();
        System.out.println("nhập số thứ hai: ");
        double hours = scanner.nextDouble();
        System.out.println("nhập số đầu tiên: ");
        double minutes = scanner.nextDouble();
        System.out.println("nhập số thứ hai: ");
        double seconds = scanner.nextDouble();

        List<Double> speeds = Speed(meters,hours,minutes,seconds);

        for (Double speed : speeds){
            System.out.println(speed);
        }
    }

    public static int Sum(int a, int b) {
        return a + b;
    }

    public static String Binary(String a, String b) {
        Integer numberA = Integer.parseInt(a,2);
        Integer numberB = Integer.parseInt(b,2);
        Integer numberC = numberA * numberB;
        return Integer.toBinaryString(numberC);
    }

    public static int Compare(int a, int b) {
        if (a > b) {
            return a;
        } else if (a == b) {
            return 0;
        } else if ((a % 6) == (b % 6)) {
            return b;
        } else {
            return b;
        }
    }

    public static List<Double> Speed(double a, double b, double c, double d) {
        double meters = a / (b * 3600 + c * 60 + d);
        double km = (a / 1000) / (b + c / 60 + d / 3600);
        double melies = (a / 1609) / (b + c / 60 + d / 3600);
        List<Double> speed = new ArrayList<>();
        speed.add(meters);
        speed.add(km);
        speed.add(melies);
        return speed;
    }
}
