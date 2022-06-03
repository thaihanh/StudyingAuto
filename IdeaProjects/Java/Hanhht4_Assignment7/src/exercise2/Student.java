package exercise2;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {

    private String first;
    private String last;
    private String email;


    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void display(){
        System.out.println(this.first + " " + this.last + " - " + this.email);
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        this.first = scanner.nextLine();
        System.out.print("Enter last name: ");
        this.last = scanner.nextLine();
        System.out.print("Enter email: ");
        this.email = scanner.nextLine();
        System.out.println();
    }
}
