package exercise1;

public class Student {
    public static void main(String[] args) {

        Student student = new Student("John", 2);
        student.display();
        System.out.println(student);

    }

    private String name;
    private int roll_no;

    //Constructor
    public Student(String name, int roll_no){
        this.name = name;
        this.roll_no = roll_no;

    }

    public void display(){
        System.out.println(this.name +  " - " + this.roll_no);
    }
}
