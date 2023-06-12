import org.example.SuggestionEngine;
import org.junit.jupiter.api.*;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Paths;


public class testSuggestions {
    SuggestionEngine allTests = new SuggestionEngine();

    @Test
    @DisplayName("Testing Correct Spelling")
    public void testGenerateSuggestionEmpty() throws Exception {
        allTests.loadDictionaryData(Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));


        Assertions.assertEquals("",allTests.generateSuggestions("wonderful"));
    }

    @Test
    @DisplayName("Testing Incorrect Spelling")
    public void testGenerateSuggestionSpelling() throws Exception{
        allTests.loadDictionaryData(Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));


        Assertions.assertTrue(allTests.generateSuggestions("testinh").contains("testing"));
    }

    @Test
    @DisplayName("Testing Using a Capital Letter")
    public void testGenerateSuggestionCapital() throws Exception{
        allTests.loadDictionaryData(Paths.get( ClassLoader.getSystemResource("words.txt").getPath()));


        Assertions.assertTrue(allTests.generateSuggestions("Easy").contains("easy"));

    }

}