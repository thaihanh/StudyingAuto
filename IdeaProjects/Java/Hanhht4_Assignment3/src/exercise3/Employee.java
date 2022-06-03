package exercise3;

public class Employee {
    public static void main(String[] args) {
        System.out.println("Name    Year of joining          Address");
        Employee employee1 = new Employee("Robert", 1994, 0, "64C- WallsStreet");
        employee1.display();
        Employee employee2 = new Employee("Sam", 2000, 0, "68D- WallsStreet");
        employee2.display();
        Employee employee3 = new Employee("John", 1999, 0, "26B- WallsStreet");
        employee3.display();

    }
    private String name;
    private int yearOfJoining;
    private double salary;
    private String address;

    //Constructor
    public Employee(String name, int yearOfJoining, double salary, String address){
        this.name = name;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
        this.address = address;

    }
    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //Display
    public void display(){
        System.out.println(this.name +  "     " + this.yearOfJoining +  "                  " + this.address );
    }
}
