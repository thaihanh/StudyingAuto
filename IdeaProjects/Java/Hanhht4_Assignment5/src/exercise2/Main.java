package exercise2;

public class Main {
    public static void main(String[] args) {

        try{
            throw new Exercise2("Hello");
        }catch (Exercise2 e){
            e.printStackTrace();
        }
    }
}
