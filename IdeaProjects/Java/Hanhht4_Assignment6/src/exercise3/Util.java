package exercise3;

public class Util {
    private int arr[];
    private int top;
    private int size;

    public Util(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public void push(int n){
        if (isFull()){
        } else {
            arr[++top] = n;
        }
    }

    public boolean isFull(){
        return this.top == this.size - 1;
    }

    public void display() {
        for (int i = 0; i <= top; i++){
            System.out.print(arr[i]);
            if(i != top){
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }

    public int pop(){
        if (isEmpty()){
            System.exit(1);
        }
        return arr[top--];

    }

    public int peek(){
        if (isEmpty()){
            System.exit(1);
        }
        return arr[top];

    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int size(){
        return top + 1;
    }

    public int max() {
        int max = arr[0];
        for (int i = 1; i <= top; i++){
            if(max < arr[i])
                max = arr[i];
        }
        return max;
    }

    public int min() {
        int min = arr[0];
        for (int i = 1; i <= top; i++){
            if(min > arr[i])
                min = arr[i];
        }
        return min;
    }

    public int search(int searchElement) {
        int index = -1;
        for (int i = 0; i <= top; i++) {
            if (searchElement == arr[i]) {
                index = i;
            }
        }
        return index;
    }
}
