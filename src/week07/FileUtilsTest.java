package week07;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;

import static org.junit.Assert.*;

public class FileUtilsTest {
    static FileUtils fileUtils;

    @BeforeClass
    public static void setUpOnce() {
        fileUtils = FileUtils.getInstance();
    }

    protected String expected;
    @Before
    public void setUp() throws Exception {
        expected = "Lorem ipsum dolor sit amet, \n consectetur adipiscing elit.";
    }

    @After
    public void tearDown() throws Exception {
        // Nothing to do here
    }

    @Test
    public void readFromShouldMatchContents() throws IOException {
        File file = new File("test.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.write(expected);
            pw.close();

            String actual = fileUtils.readFrom(file);

            assertEquals(expected, actual);
        } finally {
            file.delete();
        }
    }

    @Test
    public void writeToShouldMatchContents() throws IOException {
        File file = new File("test.txt");
        fileUtils.writeTo(expected, file);

        Charset encoding = Charset.forName("UTF-8");
        byte[] encoded = Files.readAllBytes(file.toPath());
        String actual = new String(encoded, encoding);

        assertEquals(expected, actual);
    }

    @Test
    public void parseLineShouldIgnoreComments() {
        String line = "# this=comment";
        Property result = fileUtils.parseLine(line);

        assertNull(result);
    }

    @Test
    public void parseLineShouldParseSimpleLines() {
        String line = "a=b";
        Property result = fileUtils.parseLine(line);

        assertNotNull(result);
        assertEquals(result.getKey(), "a");
        assertEquals(result.getValue(), "b");
    }
    
    @Test
    public void parseLineShouldIgnoreWhitespace() {
        String line = "     a   =       b";
        Property result = fileUtils.parseLine(line);

        assertNotNull(result);
        assertEquals(result.getKey(), "a");
        assertEquals(result.getValue(), "b");
    }
}
