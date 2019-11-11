package nio;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Main.
 *
 * @author Ilya_Sukhachev
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        Files.copy(Paths.get("note.txt"), Paths.get("newnote.txt"), StandardCopyOption.REPLACE_EXISTING);
//        Files.delete(Paths.get("note.txt"));

//        Files.move(Paths.get("note.txt"), Paths.get("newnote.txt"), StandardCopyOption.REPLACE_EXISTING);

//        RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");
//        byte[] temp = new byte[1];
//        for (int i = 0; i < raf.length(); i++) {
//            raf.read(temp, i, 1);
//        }
//        raf.writeChars("hello");
//        raf.close();

//        RandomAccessFile raf = new RandomAccessFile("test.txt", "rwd");

////        raf.writeUTF("hello world");
//        //INSERT CODE HERE
//         raf.close();
//         DataInputStream dis = new DataInputStream(new FileInputStream("test.txt"));
//         String value = dis.readUTF();
//         System.out.print(value);
//         dis.close();

        long startTime = System.currentTimeMillis();

        RandomAccessFile raf = new RandomAccessFile("file2.txt", "r");
        ByteBuffer buf = raf.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, raf.length());
        int lines = 0;
        long len = raf.length();
        for (int i = 0; i < raf.length(); i++) {
            if (buf.get(i) == '\n') {
                lines++;
            }

        }

        System.out.println(System.currentTimeMillis() - startTime);
    }
}
