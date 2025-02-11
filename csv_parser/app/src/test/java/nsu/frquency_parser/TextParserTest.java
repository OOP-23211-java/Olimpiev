package nsu.frquency_parser;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import nsu.frequency_parser.token_frequency_parser.TokenFrequencyParser;

public class TextParserTest {
    
    @Test
    public void TestTextParserInstanceAndRunWithputExcpetions() {
        try (var sb = new StringReader("Apple Orange Orange Apple Banana Orange")) {   
            TokenFrequencyParser.parse(sb);
        } catch( Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void TestTextParserInstanceAndRunForEmptyFile() {
        try (var sb = new StringReader("")) {   
            var result = TokenFrequencyParser.parse(sb);
            assertTrue(result.size() == 0);
        } catch( Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void TestTextParserInstanceAndRunForClosedFile() {
        String text = new String("Apple Orange Orange Apple Banana Orange");
        
        var sb = new StringReader(text);
        sb.close();
        
        try {   
            assertThrows("Expected IOException while parsing closed stram", IOException.class, () -> {
                TokenFrequencyParser.parse(sb);            
            });
        } catch(Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void TestTestParserForRegularFile() {
        String[] content = {"Apple", "Orange", "Orange", "Apple", "Banana", "Orange"};
        String text = String.join(" ", content);

        Multiset<String> expected = HashMultiset.create();
        for (String word : content) {
            expected.add(word);
        }

        try (StringReader sb = new StringReader(text)) {   
            var result = TokenFrequencyParser.parse(sb);

            assertNotNull("Parsed collection should not be null", result);
            assertTrue("Parsed collection should not be empty", result.size() != 0);

            result.forEach(token -> assertTrue("Result should contain: " + token, expected.contains(token)));
            expected.forEach(token -> assertTrue("Expected should contain: " + token, result.contains(token)));
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }
}
