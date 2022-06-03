package main;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String s = "Hello";

    }
    public static boolean writeObject (Object data, String path) {

        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try(FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oó = new ObjectOutputStream(fos)) {
            oos.writeObject(data);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
