package exercise2;

public class Util {

    private int arr[];
    private int index;
    private int size;

    public Util() {
        this.size = 64;
        this.arr = new int[64];
        this.index = -1;
    }

    public void push(int n){
        if (isFull()){
        } else {
            arr[++index] = n;
        }
    }

    public boolean isFull(){
        return this.index == this.size - 1;
    }

    public void display() {
        for (int i = index; i >= 0; i--){
            System.out.print(arr[i]);
            if(i != 0){
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }
}
