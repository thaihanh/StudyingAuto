package exercise2;

public class Main {
    public static void main(String[] args) {

        Util list = new Util();
        for (int i = 1; i < 65; i++) {
            list.push(i);
        }

        //in danh sach nguoc
        System.out.println("Reverse order:");
        list.display();
    }
}
