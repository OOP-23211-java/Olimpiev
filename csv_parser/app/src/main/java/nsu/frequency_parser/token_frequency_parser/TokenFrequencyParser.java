package nsu.frequency_parser.token_frequency_parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import lombok.extern.log4j.Log4j2;

/**
 * This class handles text parsing.
 */
@Log4j2
 public class TokenFrequencyParser {
    /**
     * Parses the text and returns a collection of words in multi collection.
     * @return Multiset of parsed words
     * @throws IOException if an error occurs during parsing
     */
    public static Multiset<String> parse(Reader reader) throws IOException {
        log.info("start parsing");
        Multiset<String> multiset = HashMultiset.create();

        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("[^a-zA-Z0-9]+");

                for (String word : words) {
                    multiset.add(word);
                }
            }
        } catch (IOException e) {
            log.error(String.format("сatch exception: %s - %s", e.getClass().getName(), e.getMessage()));
            System.err.println(e.getMessage());
            throw e;
        }

        log.info("finish parsing");
        return multiset;
    }
}
