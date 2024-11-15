package main.src;

/**
 * Decision-Support-Program
 * CS3250 - MSU Fall 2024
 * @Author: Tony Sandoval
 * Description: Utility Class to implement the algorithm
 */

public class DecisionAlgorithm {
    /**
     * This is where the flowchart will be implemented
     * // Step 2: Loop through each classroom and add a student to the assigned classroom objects
     *         // Iterate to get all the classroom names(keys)
     *         Iterable<String> classroomNames = classrooms.keySet();
     *
     *         // for loop to iterate through each classroom in the hashmap
     *         for (String classroomName : classroomNames) {
     *             int capacity = classrooms.get(classroomName).getCapacity();
     *             Classroom current = classrooms.get(classroomName);
     */

    // TODO: finish the implementation of the algorithm (flowchart)
    public static String decisionSupport(String decision){
        // get the object
        // loop through every factor & sum the columns
        Iterable<String> factors = decision.getFactors().keySet();
        double sum = 0.0;

        for (String factor: factors) {
            double factorSum = decision.getFactors().get(factor);

        }
        // hashmap to hold the sum of the columns
        // calculateRatios()
        // solveDecisionNumber()
        // normalize data
        // return a new hashmap with the choices and their normalized values

        return "";
    }

    public static List<HashMap<String, Double>> calculateRatios(double[][] data) {
        List<HashMap<String, Double>> ratioData = new ArrayList<>();

        int numRows = data.length;
        int numCols = data[0].length;

        // Step 1: Calculate column sums
        double[] columnSums = new double[numCols];
        for (int col = 0; col < numCols; col++) {
            for (int row = 0; row < numRows; row++) {
                columnSums[col] += data[row][col];
            }
        }

        // Step 2: Calculate ratios for each cell and store in HashMap
        for (int row = 0; row < numRows; row++) {
            HashMap<String, Double> rowRatios = new HashMap<>();
            for (int col = 0; col < numCols; col++) {
                double ratio = data[row][col] / columnSums[col];
                rowRatios.put("Column " + col, ratio);
            }
            ratioData.add(rowRatios);
        }

        return ratioData;
    }

    private static double solveDecisionNumber() {
        return 0.0;
    }


    public static double[] normalize(double[] data) {
        double max = data[0];
        // Find the maximum value
        for (double num : data) {
            if (num > max) {max = num;}
        }
        // Normalize each value by dividing by the maximum
        double[] normalizedData = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            normalizedData[i] = data[i] / max;
        }

        return normalizedData;
    }

} // end DecisionAlgorithm
