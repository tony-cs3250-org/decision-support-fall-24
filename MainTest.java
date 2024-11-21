//package main.src;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream; // For faking input
import java.util.*; // For lists and maps

public class MainTest {

    @Test
    public void testUserInput_ValidInput() {
        // Pretend someone is typing this into the console
        String simulatedInput = "Choose a programming language\n" +
                "Java, Python, C++\n" +
                "Ease of Learning, Popularity, Performance\n" +
                "5\n" +  // Popularity weight
                "8\n" +  // Performance weight
                "7\n8\n9\n" +  // Java scores
                "6\n9\n8\n" +  // Python scores
                "4\n6\n10\n";  // C++ scores

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes())); // Make System.in use this fake input

        // Call the userInput method
        Decision result = Main.userInput();

        // Check the problem statement was saved properly
        assertEquals("Choose a programming language", result.getProblemStatement());

        // Check the alternatives were saved
        assertEquals(Arrays.asList("Java", "Python", "C++"), result.getAlternatives());

        // Check the factors were calculated correctly
        Map<String, Double> expectedFactors = new HashMap<>();
        expectedFactors.put("Ease of Learning", 10.0);
        expectedFactors.put("Popularity", 50.0);
        expectedFactors.put("Performance", 80.0);
        assertEquals(expectedFactors, result.getFactors());

        // Make sure the decision data is saved right
        List<Map<String, Double>> expectedDecisionData = new ArrayList<>();
        expectedDecisionData.add(Map.of("Ease of Learning", 7.0, "Popularity", 8.0, "Performance", 9.0));
        expectedDecisionData.add(Map.of("Ease of Learning", 6.0, "Popularity", 9.0, "Performance", 8.0));
        expectedDecisionData.add(Map.of("Ease of Learning", 4.0, "Popularity", 6.0, "Performance", 10.0));
        assertEquals(expectedDecisionData, result.getDecisionData());
    }

    @Test
    public void testUserInput_EmptyFactors() {
        // Pretend input where no factors are given
        String simulatedInput = "Choose a programming language\n" +
                "Java, Python, C++\n" +
                "\n"; // No factors

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes())); // Fake input again

        // Call userInput and check the result
        Decision result = Main.userInput();

        // Problem statement should still be there
        assertEquals("Choose a programming language", result.getProblemStatement());

        // Alternatives should still be there
        assertEquals(Arrays.asList("Java", "Python", "C++"), result.getAlternatives());

        // No factors or decision data should be saved
        assertTrue(result.getFactors().isEmpty());
        assertTrue(result.getDecisionData().isEmpty());
    }

    @Test
    public void testUserInput_InvalidWeight() {
        // Simulate bad input for a factor weight
        String simulatedInput = "Choose a programming language\n" +
                "Java, Python, C++\n" +
                "Ease of Learning, Popularity\n" +
                "invalid\n"; // The user types something that isn't a number

        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        // Check if it throws an exception (InputMismatchException)
        try {
            Main.userInput();
            fail("Expected InputMismatchException was not thrown"); // Fail if no exception
        } catch (InputMismatchException e) {
            assertTrue(true); // Exception was thrown, so this is fine
        }
    }

    @Test
    public void testUserOutput() {
        // Call userOutput and make sure it returns an empty string
        String result = Main.userOutput();
        assertEquals("", result);
    }
}
