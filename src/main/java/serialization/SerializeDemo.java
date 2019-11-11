package serialization;

import serialization.entity.Line;
import serialization.entity.Person;
import serialization.entity.Point;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeDemo {

    public static final String PERSON_FILE_NAME = "./person.bin2";

    public static void main(String[] args) {
        Person person = new Person("Tom", 35, 1.75, true, "12345");
        storePersonData(person);
        storePersonObject(person);

        Person.staticString = "123123123";
        Person readed = getPersonObject();
        System.out.println(person);
        System.out.println(readed);
        System.out.println(readed.staticString);

        // балуемся с графами
        linesDemo();
    }

    private static void linesDemo() {
        Point point1 = new Point(1.0, 1.0);
        Point point2 = new Point(2.0, 2.0);
        Point point3 = new Point(3.0, 3.3);
        Line line1 = new Line(point1, point2, 1);
        Line line2 = new Line(point2, point3, 2);
        String fileName = "./lines.bin";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(line1);
            oos.writeObject(line2);
            line1.setIndex(3);
            oos.writeObject(line1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            for (int i=0; i<3; i++){
                Object line = ois.readObject();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Person getPersonObject() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PERSON_FILE_NAME))) {
            Object o = ois.readObject();
            return (Person) o;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void storePersonObject(Person person) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PERSON_FILE_NAME))) {
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void storePersonData(Person person) {
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("./person.bin"))) {
            dos.writeUTF(person.getName());
            dos.writeInt(person.getAge());
            dos.writeDouble(person.getHeigh());
            dos.writeBoolean(person.isMarried());

            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
