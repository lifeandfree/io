package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        readFile("note.txt");
        String text = "File not found";
        writeFile("note.txt", text);
        readFile("note.txt");
        addToFile("note.txt", "Hello");
    }

    public static void readFile(String filename) {
        try (FileInputStream fileInputStream = new FileInputStream(filename)) {
            System.out.println("Размер файла: " + fileInputStream.available());

            int i = -1;
            while ((i = fileInputStream.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeFile(String fileName, String content) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] buffer = content.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToFile(String fileName, String str) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("note.txt", true)) {
            byte[] buffer = str.getBytes();
            fileOutputStream.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
