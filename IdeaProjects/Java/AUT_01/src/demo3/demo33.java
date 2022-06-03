package demo3;

public class demo33 {
    public static void main(String[] args) {
        int n = 1000;
        int count = 0;

        while (count < 3) {
            n++;
            boolean result = isPrime(n);
            if (result) {
                count++;
                System.out.println(n);
            }
        }
        //System.out.println(isPrime(4));

    }
    public static boolean isPrime(int n){
        if(n < 2){
            return false;
        }

        for(int i = 2; i < n; i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
