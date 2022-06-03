package main;

import entity.Student;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOMain {

    public static void main(String[] args) {
//        byte[] arr = new byte[100];
//
//        try (InputStream is = new FileInputStream("student.txt")){
//            is.read(arr);
//            String s = new String(arr);
//            System.out.println(s);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        String data = "Test java output stream.";
//
//        try (OutputStream os = new FileOutputStream("student.txt")){
//            byte[] byteData = data.getBytes();
//            os.write(byteData);
//            System.out.println("OK");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Student student = new Student();
//        student.input();
//
////        String s = "Hello";
//        boolean check = writeObject(student, "student.txt");
//        if(check){
//            System.out.println("OK");
//        } else {
//            System.out.println("Error");
//        }

//        String result = (String) readObject("student.txt");
//        System.out.println(result);

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
