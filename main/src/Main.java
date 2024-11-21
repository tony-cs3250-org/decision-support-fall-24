package main.src;

import java.util.*;

/**
 * Decision-Support-Program
 * CS3250 - MSU Fall 2024
 * @Author: Tony Sandoval
 */


public class Main {

    public static void main(String[] args) {
        /*
         * This is the entry point of the program, this is where the user will be prompted for all input
         * using scanner. The data will then be used to instantiate a "Decision" object on which "DecisionAlgorithm"
         * will be run on to produce and output.
         * The private methods are a way to modularize the code without having to create many different classes.
         * This also is more consistent with the object-oriented-programing paradigm.
         * - T.S
         */

        System.out.print("Welcome to the Decision-Support-Program! \n" +
                        "Start by entering your problem statement and the multiple decisions you are considering . . ."
                );
        // run user input to instantiate a Decision object
        // this will return a 'decision' object which will be the parameter to the decisionAlgorithm
        Decision userInputProblem = userInput();

        // This is where the object will be passed into the algorithm solver
        //userInputProblem = DecisionAlgorithm.decisionSupport(userInputProblem);
        Map<String, Double> results = DecisionAlgorithm.decisionSupport(userInputProblem);


        // return the solution
        System.out.println("Here is the best decision: " + userInputProblem.toString());
        System.out.println("Here is the best decision: " + results.toString());
        // TODO: format the solution to print out







    }

    /**
     * This is where the private methods will live
     */
    // TODO: finish the implementation of the userInput() method. Return a decision object
    static Decision userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the problem statement:");
        String problemStatement = sc.nextLine();

        System.out.println("Enter the alternatives (choices), separated by commas:");
        String choicesInput = sc.nextLine();
        List<String> choices = Arrays.asList(choicesInput.split("\\s*,\\s*"));

        System.out.println("Enter the factors, separated by commas:");
        String factorsInput = sc.nextLine();
        List<String> factorList = Arrays.asList(factorsInput.split("\\s*,\\s*"));
        Map<String, Double> factors = new HashMap<>();

        // Get factor weights
        for (int i = 0; i < factorList.size(); i++) {
            double weight = 10.0; // Default weight for the first factor
            if (i > 0) {
                System.out.println("If " + factorList.get(0) + " is a 10, how much more important is " + factorList.get(i) + "?");
                weight = sc.nextDouble();
            }
            factors.put(factorList.get(i), weight);
        }

        List<HashMap<String, Double>> decisionData = new ArrayList<>();
        for (String choice : choices) {
            HashMap<String, Double> choiceData = new HashMap<>();
            System.out.println("Enter the factors for " + choice + ":");
            for (String factor : factorList) {
                System.out.println("Enter the value for " + factor + " (1-10):");
                double value = sc.nextDouble();
                choiceData.put(factor, value);
            }
            decisionData.add(choiceData);
        }

        return new Decision(problemStatement, choices, factors, decisionData);
    }

    // TODO: finish the implementation of the userOutput() method. Return a decision object

    static String userOutput() {
        return "";
    }


} // end Main
