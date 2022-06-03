package exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        long n = pow(4,4);
        System.out.println(n);
//        int n = 1000;
//        int count = 0;
//
//        while (count < 3) {
//            n++;
//            boolean result = isPrime(n);
//            if (result) {
//                count++;
//                System.out.println(n);
            }

    public static long pow(int n, int m) {
        long result = 1;
        for (int i = 1; i <= m; i++) {
            result *= n;
        }
        return result;
    }

    public static boolean isArmstrong(int n){
        if(n)
    }
//        if(n < 2){
//            return false;
//        }
//
//        for(int i = 2; i < n; i++){
//            if (n % i == 0) {
//                return false;
//            }
//        }
//        return true;
    }
