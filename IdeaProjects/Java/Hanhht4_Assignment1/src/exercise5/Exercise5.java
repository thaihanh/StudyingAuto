package exercise5;

import java.math.MathContext;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter distance in meters: ");
        double m = scanner.nextDouble();
        System.out.print("Enter number of hours: ");
        double hh = scanner.nextDouble();
        System.out.print("Enter number of minutes: ");
        double mm = scanner.nextDouble();
        System.out.print("Enter number of seconds: ");
        double ss = scanner.nextDouble();

        System.out.println("-----------------------------------------------------------");
        //speed in meters per second (approximate)
        double v1 = m / calculateTotalSeconds(hh,mm,ss);
        //Lấy 8 số sau dấu phẩy
        //double v1 = Math.round(approximateV1 * 100000000 / 100000000);
        System.out.println("Your speed in meters/second is " + v1);

        //speed in kilometers per hour
        double v2 = v1 * 3600  / 1000;
        System.out.println("Your speed in km/h is " + v2);

        //speed in miles per hour
        double v3 = v1 * 3600 / 1609;
        System.out.println("Your speed in miles/h is " + v3);
        }
    //total seconds
    public static double calculateTotalSeconds(double hh, double mm, double ss){
        return (hh*60*60 + mm*60 + ss);
    }
}
