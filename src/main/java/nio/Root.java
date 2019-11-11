package nio;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Root.
 *
 * @author Ilya_Sukhachev
 */
public class Root {

    public static void main(String[] args) {
        File[] roots = File.listRoots();
        for(File f : roots) {
            System.out.println(f);
        }

//        Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
//        for(Path p : roots){
//            System.out.println(p);
//        }

//        FileSystem fs = FileSystems.getDefault();
//        Iterable<Path> roots = fs.getRootDirectories();
//        for(Path p : roots){
//            System.out.println(p);
//        }


    }
}
