package serialization;

import java.io.*;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;

public class StreamDemo {

    public static void main(String[] args) throws IOException {
//        testFileStreams();
        testByteStreams();
//        testFileStreamsWithAutoClose();
    }

    private static void testFileStreams(){
        InputStream inputStream = null;
        Exception ex = null;
        try {
            inputStream = new ErrorInputStreamReader("./.gitignore");
            System.out.println("Размер файла: " + inputStream.available());
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
            throw new IOException("Я так захотел");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println();
            ex = e;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    if (ex != null) {
                        e.addSuppressed(ex);
                    }
                    e.printStackTrace();
                }
            }
        }
    }

    private static void testFileStreamsWithAutoClose() {
        try (InputStream inputStream = new ErrorInputStreamReader("./.gitignore")){
            System.out.println("Размер файла: " + inputStream.available());
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String s;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
            throw new IOException("Я так захотел");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void testByteStreams() throws IOException {
        byte[] arr = "hello Мир!".getBytes(); // new byte[]{1,3,4,6,7,8,9};
        InputStream byteArrayInputStream = new ByteArrayInputStream(arr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int b;
        while ((b=byteArrayInputStream.read()) != -1) {
            System.out.println((char)b);
            byteArrayOutputStream.write(b);
        }

        System.out.println(byteArrayOutputStream.toString());

    }

}

class ErrorInputStreamReader extends FileInputStream {

    public ErrorInputStreamReader(String name) throws FileNotFoundException {
        super(name);
    }

    @Override
    public void close() throws IOException {
        super.close();
        throw new IOException("Ошибка в методе close");
    }
}