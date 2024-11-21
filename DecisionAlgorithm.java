import java.util.*;

/**
 * Decision-Support-Program
 * CS3250 - MSU Fall 2024
 * @Author: Tony Sandoval
 * Description: Utility Class to implement the decision-making algorithm based on the Decision class.
 */
public class DecisionAlgorithm {

    /**
     * Implements the decision support algorithm based on the Decision object.
     * @param decision The Decision object containing problem statement, alternatives, factors, and decision data.
     * @return A Map of alternatives and their normalized decision numbers.
     */
    public static Map<String, Double> decisionSupport(Decision decision) {
        // Extract factor names and alternative names
        List<String> factorNames = new ArrayList<>(decision.getFactors().keySet());
        List<String> alternativeNames = decision.getAlternatives();

        int numAlternatives = alternativeNames.size();
        int numFactors = factorNames.size();

        // Build data array
        double[][] data = new double[numAlternatives][numFactors];
        List<HashMap<String, Double>> decisionData = decision.getDecisionData();

        for (int i = 0; i < numAlternatives; i++) {
            HashMap<String, Double> alternativeData = decisionData.get(i);
            for (int j = 0; j < numFactors; j++) {
                String factorName = factorNames.get(j);
                double value = alternativeData.get(factorName);
                data[i][j] = value;
            }
        }

        // Calculate ratios
        double[][] ratios = calculateRatios(data);

        // Get weights from factors
        double[] weights = new double[numFactors];
        for (int j = 0; j < numFactors; j++) {
            String factorName = factorNames.get(j);
            weights[j] = decision.getFactors().get(factorName);
        }

        // Solve decision numbers using ratios and weights
        double[] decisionNumbers = solveDecisionNumbers(ratios, weights);

        // Normalize decision numbers
        double[] normalizedDecisionNumbers = normalize(decisionNumbers);

        // Create a Map of alternatives and their normalized scores
        Map<String, Double> result = new LinkedHashMap<>();
        for (int i = 0; i < alternativeNames.size(); i++) {
            result.put(alternativeNames.get(i), normalizedDecisionNumbers[i]);
        }

        return result;
    }

    /**
     * Calculates the ratios by dividing each element by the sum of its column.
     * @param data A 2D array of original data.
     * @return A 2D array of ratios.
     */
    public static double[][] calculateRatios(double[][] data) {
        int numRows = data.length;
        int numCols = data[0].length;

        // Calculate column sums
        double[] columnSums = new double[numCols];
        for (int col = 0; col < numCols; col++) {
            double sum = 0.0;
            for (int row = 0; row < numRows; row++) {
                sum += data[row][col];
            }
            columnSums[col] = sum;
        }

        // Calculate ratios
        double[][] ratios = new double[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                ratios[row][col] = data[row][col] / columnSums[col];
            }
        }

        return ratios;
    }

    /**
     * Solves the decision numbers by summing the weighted ratios for each alternative.
     * @param ratios A 2D array of ratios.
     * @param weights An array of factor weights.
     * @return An array of decision numbers.
     */
    public static double[] solveDecisionNumbers(double[][] ratios, double[] weights) {
        int numRows = ratios.length;
        int numCols = ratios[0].length;

        double[] decisionNumbers = new double[numRows];
        for (int row = 0; row < numRows; row++) {
            double sum = 0.0;
            for (int col = 0; col < numCols; col++) {
                sum += ratios[row][col] * weights[col];
            }
            decisionNumbers[row] = sum;
        }

        return decisionNumbers;
    }

    /**
     * Normalizes an array of data by dividing each element by the maximum value.
     * @param data An array of decision numbers.
     * @return An array of normalized decision numbers.
     */
    public static double[] normalize(double[] data) {
        double max = data[0];
        // Find the maximum value
        for (double num : data) {
            if (num > max) {
                max = num;
            }
        }
        // Normalize each value by dividing by the maximum
        double[] normalizedData = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            normalizedData[i] = data[i] / max;
        }

        return normalizedData;
    }

} // end DecisionAlgorithm
