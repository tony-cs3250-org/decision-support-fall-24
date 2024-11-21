import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecisionTest {

    @Test
    public void testDecisionConstructor() {
        // Setting up a test case for the constructor
        String problemStatement = "Choose a vacation destination"; // The problem statement
        List<String> alternatives = Arrays.asList("Beach", "Mountain", "City"); // Options to pick from
        Map<String, Double> factors = new HashMap<>();
        factors.put("Cost", 10.0); // Factor 1
        factors.put("Activities", 8.0); // Factor 2
        factors.put("Weather", 9.0); // Factor 3

        // Decision data for each alternative
        List<HashMap<String, Double>> decisionData = new ArrayList<>();
        decisionData.add(new HashMap<>(Map.of("Cost", 7.0, "Activities", 9.0, "Weather", 8.0)));
        decisionData.add(new HashMap<>(Map.of("Cost", 6.0, "Activities", 8.0, "Weather", 9.0)));
        decisionData.add(new HashMap<>(Map.of("Cost", 5.0, "Activities", 7.0, "Weather", 10.0)));

        // Creating the Decision object
        Decision decision = new Decision(problemStatement, alternatives, factors, decisionData);

        // Check if the constructor worked
        assertEquals("Choose a vacation destination", decision.getProblemStatement()); // Is the problem statement right?
        assertEquals(alternatives, decision.getAlternatives()); // Are the alternatives saved properly?
        assertEquals(factors, decision.getFactors()); // Did the factors get saved?
        assertEquals(decisionData, decision.getDecisionData()); // Does the decision data match?
    }

    @Test
    public void testSetters() {
        // Start with an empty Decision object
        Decision decision = new Decision("", new ArrayList<>(), new HashMap<>(), new ArrayList<>());

        // Test setting the problem statement
        decision.setProblemStatement("Choose a hobby");
        assertEquals("Choose a hobby", decision.getProblemStatement()); // Did it update correctly?

        // Test setting the alternatives
        List<String> newAlternatives = Arrays.asList("Reading", "Gaming", "Hiking"); // New options
        decision.setAlternatives(newAlternatives);
        assertEquals(newAlternatives, decision.getAlternatives()); // Check if updated

        // Test setting the factors
        Map<String, Double> newFactors = new HashMap<>();
        newFactors.put("Time", 5.0);
        newFactors.put("Cost", 7.0);
        decision.setFactors(newFactors);
        assertEquals(newFactors, decision.getFactors()); // Check if factors were updated

        // Test setting the decision data
        List<HashMap<String, Double>> newDecisionData = new ArrayList<>();
        newDecisionData.add(new HashMap<>(Map.of("Time", 6.0, "Cost", 8.0))); // New decision data
        decision.setDecisionData(newDecisionData);
        assertEquals(newDecisionData, decision.getDecisionData()); // Is the data updated correctly?
    }

    @Test
    public void testToString() {
        // Create a Decision object to test the toString method
        String problemStatement = "Choose a job"; // Problem
        List<String> alternatives = Arrays.asList("Engineer", "Doctor", "Artist"); // Choices
        Map<String, Double> factors = new HashMap<>();
        factors.put("Salary", 10.0); // Factor 1
        factors.put("Work-Life Balance", 8.0); // Factor 2

        // Decision data for each choice
        List<HashMap<String, Double>> decisionData = new ArrayList<>();
        decisionData.add(new HashMap<>(Map.of("Salary", 9.0, "Work-Life Balance", 7.0)));
        decisionData.add(new HashMap<>(Map.of("Salary", 8.0, "Work-Life Balance", 6.0)));
        decisionData.add(new HashMap<>(Map.of("Salary", 7.0, "Work-Life Balance", 8.0)));

        // Create the object
        Decision decision = new Decision(problemStatement, alternatives, factors, decisionData);

        // Expected output for toString
        String expected = "Decision{ProblemStatement='Choose a job', alternatives=[Engineer, Doctor, Artist], factors={Salary=10.0, Work-Life Balance=8.0}, decisionData=[{Salary=9.0, Work-Life Balance=7.0}, {Salary=8.0, Work-Life Balance=6.0}, {Salary=7.0, Work-Life Balance=8.0}]}";

        // Check if toString produces the right output
        assertEquals(expected, decision.toString());
    }

    @Test
    public void testEdgeCases() {
        // Test case where there are no alternatives
        Decision decision1 = new Decision("No alternatives", new ArrayList<>(), new HashMap<>(), new ArrayList<>());
        assertEquals("No alternatives", decision1.getProblemStatement());
        assertTrue(decision1.getAlternatives().isEmpty()); // No alternatives
        assertTrue(decision1.getFactors().isEmpty()); // No factors
        assertTrue(decision1.getDecisionData().isEmpty()); // No decision data

        // Test case where everything is null
        Decision decision2 = new Decision(null, null, null, null);
        assertNull(decision2.getProblemStatement()); // Problem statement is null
        assertNull(decision2.getAlternatives()); // Alternatives are null
        assertNull(decision2.getFactors()); // Factors are null
        assertNull(decision2.getDecisionData()); // Decision data is null
    }
}
