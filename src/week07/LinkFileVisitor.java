package week07;

import static java.nio.file.FileVisitResult.*;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class LinkFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        if (attr.isSymbolicLink()) {
            try {
                Files.readSymbolicLink(file);
            } catch (IOException ioe) {
                System.err.println("Invalid symbolic link");
                ioe.printStackTrace();
            }
        }
        return CONTINUE;
    }
}