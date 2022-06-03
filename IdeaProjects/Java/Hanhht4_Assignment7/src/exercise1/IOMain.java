package exercise1;

import java.io.*;

public class IOMain {
    public static void main(String[] args) {
        String data = "This is a plain text.";
        byte[] byteData = null;

        try (OutputStream os = new FileOutputStream("assignment7.txt")){
            byteData = data.getBytes();
            os.write(byteData);
            System.out.println("OK");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (InputStream is = new FileInputStream("assignment7.txt")){
            is.read(byteData);
            String s = new String(byteData);
            System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
