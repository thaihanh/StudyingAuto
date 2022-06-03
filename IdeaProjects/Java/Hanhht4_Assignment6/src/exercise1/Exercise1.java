package exercise1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Exercise1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a","b","c"));
        System.out.println("List is " + list);
        list.set(1, "Specified element");
        System.out.println("New list is " + list);
    }
}
