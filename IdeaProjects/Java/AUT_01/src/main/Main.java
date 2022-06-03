package main;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        int result = m.sum(24, 8);
        System.out.println(result);

        m.display(22);
        m.displayStr("xinchao");
    }

    public int sum(int a, int b){
        int result = a + b;
        return result;
    }
    //Ham void la ham khong tra ve gi ca
    public void display(int a){
        System.out.println("a = " + a);
    }

    public void displayStr(String a){
        System.out.println(a);
    }
}
