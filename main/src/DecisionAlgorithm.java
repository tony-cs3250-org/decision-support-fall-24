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
    public static String decisionSupport(Decision decision){
        // get the object
        // loop through every factor & sum the columns
        Iterable<String> factors = decision.getFactors().keySet();
        double sum = 0.0;

        for (String factor: factors) {
            double factorSum = decision.getFactors().get(factor);

        }
        // hashmap to hold the sum of the columns
        // calculateRations()
        // solveDecisionNumber()
        // normalize data
        // return a new hashmap with the choices and their normalized values

        return "";
    }

    private static double calculateRatios() {
        return 0.0;
    }

    private static double solveDecisionNumber() {
        return 0.0;
    }

    private static double normalize() {
        return 0.0;
    }

} // end DecisionAlgorithm