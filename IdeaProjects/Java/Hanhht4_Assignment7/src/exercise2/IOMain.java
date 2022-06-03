package exercise2;

import java.io.*;

public class IOMain {
    public static void main(String[] args) {

        Student student = new Student();
        student.input();

        boolean check = writeObject(student, "student.txt");
        if(check){
            System.out.println("OK");
        } else {
            System.out.println("Error");
        }

        Student result = (Student) readObject("student.txt");
        result.display();

    }

    public static boolean writeObject(Object data, String path){

        File file = new File(path);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(data);
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Object readObject(String path){
        try(FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis)){
            return ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
