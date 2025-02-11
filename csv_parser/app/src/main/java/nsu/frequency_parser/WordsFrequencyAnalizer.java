package nsu.frequency_parser;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Comparator;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

import nsu.frequency_parser.csvwriter.CsvWriter;
import nsu.frequency_parser.token_frequency_parser.TokenFrequencyParser;

public class WordsFrequencyAnalizer {
    public static void Analize(Reader reader, Writer writer) throws IOException {
        String[] csvHeaders = {"Word", "Frequency", "Percent (%)"};

        try (CsvWriter csvWriter = new CsvWriter(new BufferedWriter(writer), csvHeaders)) {
            var parsed = TokenFrequencyParser.parse(reader);

            Multiset<String> sortedMultiset = TreeMultiset.create(Comparator.comparingInt(parsed::count).reversed());
            sortedMultiset.addAll(parsed);

            for (var entry : parsed.entrySet()) {
                csvWriter.writeRecord(entry.getElement(), entry.getCount(), (double)entry.getCount() / parsed.size());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw e;
        }        
    }
}
