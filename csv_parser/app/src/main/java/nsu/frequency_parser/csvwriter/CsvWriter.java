package nsu.frequency_parser.csvwriter;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import lombok.extern.log4j.Log4j2;

/**
 * A class for writing records to a CSV file using Apache Commons CSV library.
 * <p>
 * This class handles the creation of a CSV writer and ensures that records
 * are written to a given appendable stream. It also handles closing the
 * writer after the writing is complete.
 * </p>
 */
@Log4j2
public class CsvWriter implements AutoCloseable {

    private final CSVPrinter printer;

    /**
     * Constructs a CsvWriter that writes to the given appendable with specified headers.
     * 
     * @param appendable The target appendable (e.g., file or StringBuilder).
     * @param headers The headers to be written as the first row in the CSV.
     * @throws IOException If an I/O error occurs while initializing the CSV printer.
     */
    public CsvWriter(Appendable appendable, String[] headers) throws IOException {
        log.info("Initializing CsvWriter with headers: " + String.join(", ", headers));

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(headers)
                .build();

        this.printer = new CSVPrinter(appendable, csvFormat);

        log.info("CsvWriter initialized successfully.");
    }

    /**
     * Writes a record to the CSV file.
     * 
     * @param values The values to be written as a new record in the CSV.
     * @throws IOException If an I/O error occurs while writing the record.
     */
    public void writeRecord(Object... values) throws IOException {
        if (values.length == 0) {
            return;
        }

        log.info(String.format("Writing record: %s", Arrays.toString(values)));
        printer.printRecord(values);
        log.info("Record written successfully.");
    }

    /**
     * Closes the CsvWriter and releases any resources associated with it.
     * 
     * @throws IOException If an I/O error occurs while closing the printer.
     */
    @Override
    public void close() throws IOException {
        log.info("Closing CsvWriter...");
        printer.close();
        log.info("CsvWriter closed successfully.");
    }
}
