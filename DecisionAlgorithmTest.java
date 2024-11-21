import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*; // To use Maps and Lists

public class DecisionAlgorithmTest {

    @Test
    public void testDecisionSupport_ValidInput() {
        // Pretend there's a decision about choosing a car
        String problemStatement = "Choose a car";
        List<String> alternatives = Arrays.asList("Car A", "Car B", "Car C");
        Map<String, Double> factors = new HashMap<>();
        factors.put("Price", 10.0);
        factors.put("Fuel Efficiency", 50.0);
        factors.put("Comfort", 70.0);

        List<HashMap<String, Double>> decisionData = new ArrayList<>();
        decisionData.add(new HashMap<>(Map.of("Price", 5.0, "Fuel Efficiency", 8.0, "Comfort", 9.0)));
        decisionData.add(new HashMap<>(Map.of("Price", 6.0, "Fuel Efficiency", 7.0, "Comfort", 8.0)));
        decisionData.add(new HashMap<>(Map.of("Price", 4.0, "Fuel Efficiency", 9.0, "Comfort", 7.0)));

        Decision decision = new Decision(problemStatement, alternatives, factors, decisionData);

        // Call the decisionSupport method
        Map<String, Double> result = DecisionAlgorithm.decisionSupport(decision);

        // Check that all alternatives are in the result
        assertTrue(result.containsKey("Car A"));
        assertTrue(result.containsKey("Car B"));
        assertTrue(result.containsKey("Car C"));

        // Make sure the max score is normalized to 1.0
        double maxScore = Collections.max(result.values());
        assertEquals(1.0, maxScore, 0.001);

        // The result shouldn't be empty
        assertFalse(result.isEmpty());
    }

    @Test
    public void testCalculateRatios() {
        // Pretend this is the decision data
        double[][] data = {
                {10, 20, 30},
                {5, 15, 25},
                {15, 10, 5}
        };

        // Call the method
        double[][] ratios = DecisionAlgorithm.calculateRatios(data);

        // Check if the ratios are correct (column sums are 30, 45, 60)
        assertEquals(10.0 / 30, ratios[0][0], 0.001);
        assertEquals(20.0 / 45, ratios[0][1], 0.001);
        assertEquals(5.0 / 60, ratios[2][2], 0.001);
    }

    @Test
    public void testNormalize_AllZeroes() {
        // All-zero data
        double[] data = {0, 0, 0};

        // Call the normalize method
        double[] normalized = DecisionAlgorithm.normalize(data);

        // Every value should still be zero
        for (double num : normalized) {
            assertEquals(0.0, num, 0.001);
        }
    }
}
