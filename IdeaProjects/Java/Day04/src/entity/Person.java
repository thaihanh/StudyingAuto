package entity;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Person implements Serializable {

        private String account;
        private String fullName;
        private boolean gender;
        private String mobile;
        private String email;

        //constructor

        //constructor khong tham so
        public Person() {
        }

        //constructor full tham so
        public Person(String account, String fullName, boolean gender, String classRoom, String mobile, String email, double mark) {
            this.account = account;
            this.fullName = fullName;
            this.gender = gender;
            this.mobile = mobile;
            this.email = email;
        }

        //Getter and Setter
        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public boolean isGender() {
            return gender;
        }

        public void setGender(boolean gender) {
            this.gender = gender;
        }


        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void display(){
            System.out.println("Student information: ");
            System.out.print(this.account + " - " + this.fullName + " - " + this.displayGender() + " - "
                    + this.mobile + " - " + this.email) ;
        }

        private String displayGender(){
            return this.gender ? "Nam" : "Nữ";
        }

        public void input(){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a account: ");
            this.account = scanner.nextLine();
            System.out.print("Enter a fullName: ");
            this.fullName = scanner.nextLine();
            System.out.print("Enter gender: ");
            this.gender = Boolean.parseBoolean(scanner.nextLine());
            System.out.print("Enter a mobile number: ");
            this.mobile = scanner.nextLine();
            System.out.print("Enter a email: ");
            this.email = scanner.nextLine();
        }
}
