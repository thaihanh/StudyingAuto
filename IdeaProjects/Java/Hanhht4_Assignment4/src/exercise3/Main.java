package exercise3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CharSequenceImpl charSequence = new CharSequenceImpl();

        //dung constructor khong tham so
        charSequence.setText("Write a class that implements the CharSequence interface found in the java.lang package. Your\n" +
                "implementation should return the string backwards. Select one of the sentences from this book to use as the\n" +
                "data. Write a small main method to test your class; make sure to call all four methods");
        //dung constructor co tham so
//        CharSequenceImpl charSequence1 = new CharSequenceImpl("Write a class that implements the CharSequence interface found in the java.lang package. Your\\n\" +\n" +
//                "                \"implementation should return the string backwards. Select one of the sentences from this book to use as the\\n\" +\n" +
//                "                \"data. Write a small main method to test your class; make sure to call all four methods ABC");

        System.out.println("Text length: " + charSequence.length());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter index: ");
        String index = scanner.nextLine();
        System.out.println("Character in index " + index + " = " + charSequence.charAt(Integer.parseInt(index)));

//        System.out.println(charSequence.subSequence(0, charSequence.length()));
        System.out.println("The string backwards:");
        int i = charSequence.length();
        while(i>0) {
            System.out.print(charSequence.charAt(i-1));
            i--;
        }
    }
}
