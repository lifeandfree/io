package scannerRead;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerRead {

    private static List<String> strLists = new ArrayList();

    public static void main(String[] args) throws IOException {
        File file = new File("note.txt");
        List<String> stringList = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                stringList.add(line);
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        stringList = Files.readAllLines(Paths.get("note.txt"));
        stringList.forEach(System.out::println);
    }
}
