package byteArray;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        byte[] array1 = new byte[]{1, 3, 5, 7};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(array1);
        int b;
        while ((b = byteArrayInputStream.read()) != -1) {
            System.out.println(b);
        }

        String text = "Hello, world";
        array1 = text.getBytes(Charset.defaultCharset());
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(array1);
        while ((b = byteArrayInputStream2.read()) != -1) {
            System.out.print((char) b);
        }
    }
}
