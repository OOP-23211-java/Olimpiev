package nsu.frquency_parser;

import org.junit.Before;
import org.junit.Test;

import nsu.frequency_parser.csvwriter.CsvWriter;

import java.io.IOException;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class CsvWriterTest {

    private static final String[] HEADERS = {"Name", "Age", "Location"};
    private static final String[] RECORD = {"John", "25", "New York"};
    private static final String[] RECORD2 = {"Alice", "30", "Paris"};
    private static final String[] RECORD3 = {"Bob", "22", "Berlin"};

    private CsvWriter csvWriter;
    private StringWriter stringWriter;

    @Before
    public void setUp() throws IOException {
        stringWriter = new StringWriter();
        csvWriter = new CsvWriter(stringWriter, HEADERS);
    }

    @Test
    public void testConstructorInitialization() {
        try {
            new CsvWriter(new StringWriter(), HEADERS);

            String result = stringWriter.toString();

            assertTrue(result.contains("Name"));
            assertTrue(result.contains("Age"));
            assertTrue(result.contains("Location"));
            } catch (IOException e) {
                fail("IOException should not be thrown when initializing CsvWriter.");
            }
    }

    @Test
    public void testWriteRecord() throws IOException {
        csvWriter.writeRecord(RECORD);

        String result = stringWriter.toString();
        assertTrue(result.contains("John"));
        assertTrue(result.contains("25"));
        assertTrue(result.contains("New York"));
    }

    @Test
    public void testWriteMultipleRecords() throws IOException {
        csvWriter.writeRecord(RECORD);
        csvWriter.writeRecord(RECORD2);
        csvWriter.writeRecord(RECORD3);

        String result = stringWriter.toString();
        assertTrue(result.contains("John"));
        assertTrue(result.contains("25"));
        assertTrue(result.contains("New York"));
        assertTrue(result.contains("Alice"));
        assertTrue(result.contains("30"));
        assertTrue(result.contains("Paris"));
        assertTrue(result.contains("Bob"));
        assertTrue(result.contains("22"));
        assertTrue(result.contains("Berlin"));
    }
}
