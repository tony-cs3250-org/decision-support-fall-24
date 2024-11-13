/**
 * Decision-Support-Program
 * CS3250 - MSU Fall 2024
 * @Author: Tony Sandoval
 */
public class Main {
    public static void main(String[] args) {
        /**
         * This is the entry point of the program, this is where the user will be prompted for all input
         * using scanner. The data will then be used to instantiate a "Decision" object on which "DecisionAlgorithm"
         * will be run on to produce and output.
         * The private methods are a way to modularize the code without having to create many different classes.
         * This also is more consistent with the object-oriented-programing paradigm.
         * - T.S
         */

        System.out.println('Welcome to the Decision-Support-Program!' +
                'Start by entering your problem statement and the multiple decisions you are considering . . .'
                );
        // run user input to instantiate a Decision object
        // this will return a 'decision' object which will be the parameter to the decisionAlgorithm
        userInputProblem = userInput();

        // This is where the object will be passed into the algorithm solver
        DecisionAlgorithm dscAlgorithm = new DecisionAlgorithm();
        solution = dscAlgorithm.decisionSupport(userInputProblem);







    }

    /**
     * This is where the private methods will live
     */

    private static Decision userInput() {
        return decision;
    }

} // end Main
