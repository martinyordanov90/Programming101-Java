package week07;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * Created by plamen on 1/18/16.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileUtils fu = FileUtils.getInstance();
        fu.decompress(Paths.get("/home/plamen/buffalo.compressed"));
    }
}
