package exercise1;

import java.io.FileNotFoundException;

public class Main {


    public static void main(String[] args) throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            throw new Exception("File not found");
        } finally {
            System.out.println("I was in the finally clause!");
        }
    }
}
