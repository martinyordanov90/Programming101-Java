package week07;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUtils {
    private FileUtils() {

    }

    private static FileUtils mInstance;

    public static FileUtils getInstance() {
        if (mInstance == null) {
            mInstance = new FileUtils();
        }

        return mInstance;
    }

    public String readFrom(File file) throws IOException {
        BufferedReader buf = null;
        StringBuilder builder = new StringBuilder();

        try (buf = new BufferedReader(new FileReader(file))){
            String line;

            builder.append(buf.readLine());
            while ((line = buf.readLine()) != null) {
                builder.append(System.lineSeparator());
                builder.append(line);
                }
            }
        }

        return builder.toString();
    }

    public String readFrom(Path path) throws IOException {
        return readFrom(path.toFile());
    }

    public void writeTo(String contents, File file) throws IOException {
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(file))) {
            buf.write(contents);
        }
    }

    public void writeTo(String contents, Path path) throws IOException {
        writeTo(contents, path.toFile());
    }

    public Property parseLine(String line) {
        if (line.charAt(0) == '#') {
            return null;
        }
        line = line.replace("\\s+", "");
        if (line.charAt(1) != '=') {
            return null;
        }
        String[] lineValues = line.split("=", 2);
        return new Property(lineValues[0], lineValues[1]);
    }

    public Map<String, String> parseProperties(File file) throws IOException {
        Map<String, String> properties = new HashMap<>();

        try (BufferedReader buf = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = buf.readLine()) != null) {
                Property lineProperty = parseLine(line);
                
                if (lineProperty != null) {
                    properties.put(lineProperty.getKey(), lineProperty.getValue());
                }
            }
        }

        return properties;
    }

    public WordCountResult wordCount(File file) throws IOException {
        int words = 0;
        int lines = 0;
        int characters = 0;

        try (BufferedReader buf = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = buf.readLine()) != null) {
                lines++;

                Pattern word = Pattern.compile("\\w+");
                Matcher m = word.matcher(line);
                while (m.find()) {
                    words++;
                }

                characters += line.length();
            }
        }

        return new WordCountResult(words, lines, characters);
    }

    public void fixEncoding(Path path) throws IOException {
        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");

        try (FileInputStream fis = new FileInputStream(path.toFile());
             FileOutputStream fos = new FileOutputStream("fixed-" + path.toString())) {
            int c;
            byte[] bytes = new byte[128];
            while ((c = fis.read(bytes)) != -1) {
                ByteBuffer inputBuffer = ByteBuffer.wrap(bytes);
                CharBuffer data = windows1251.decode(inputBuffer);
                ByteBuffer outputBuffer = utf8.encode(data);

                byte[] output = outputBuffer.array();
                fos.write(output);
            }
        }
    }

    public String reduceFilePath(String pathStr) {
        return Paths.get(pathStr).normalize().toString();
    }

    public void findBrokenLinks(Path path) throws IOException {
        LinkFileVisitor lfv = new LinkFileVisitor();
        Files.walkFileTree(path, lfv);
    }

    public void compress(Path filePath) throws IOException {
        int index = 0;
        Map<String, Integer> wordIndex = new HashMap<>();

        String filePathNoExtension = filePath.toString().replaceFirst("\\.[^.]+$", "");
        String newFilePath = filePathNoExtension + ".compressed";

        String output = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toString()))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!wordIndex.containsKey(word)) {
                        wordIndex.put(word, index++);
                    }
                }
                sb.append(line);
            }

            output = sb.toString();

            for (Map.Entry entry : wordIndex.entrySet()) {
                String word = (String) entry.getKey();

                output = output.replaceAll(
                        "\\b" + word + "\\b",
                        String.format("~%d", entry.getValue())
                );
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(newFilePath))) {
            writer.write(output);
        }

        String wordIndexPath = filePathNoExtension + ".wi";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(wordIndexPath))) {
            oos.writeObject(wordIndex);
        }
    }

    public void decompress(Path filePath) throws IOException, ClassNotFoundException {
        String filePathNoExtension = filePath.toString().replaceFirst("\\.[^.]+$", "");
        String wordIndexPath = filePathNoExtension + ".wi";

        int index = 0;
        Map<String, Integer> wordIndex;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(wordIndexPath))) {
            wordIndex = (Map<String, Integer>) ois.readObject();
        }

        String newFilePath = filePathNoExtension + ".txt";

        String output = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toString()))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            output = sb.toString();

            for (Map.Entry entry : wordIndex.entrySet()) {
                String word = (String) entry.getKey();

                output = output.replaceAll(
                        String.format("~%d", entry.getValue()),
                        word
                );
            }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(newFilePath))) {
            writer.write(output);
        }
    }
}