package week11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class Wget {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);

            URL url = null;
            try {
                url = new URL(arg);
            } catch (MalformedURLException e) {
                System.out.println("Invalid URL");
            }

            try (BufferedInputStream bis = new BufferedInputStream(url.openStream());
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(arg).getName()))) {
                int data;
                while ((data = bis.read()) != -1) {
                    bos.write(data);
                }
            } catch (IOException e) {
                System.out.println("Error while reading");
            } catch (NullPointerException e) {
                System.out.println("Error opening stream");
            }
        }
    }
}
