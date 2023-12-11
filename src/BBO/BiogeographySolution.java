package BBO;

import java.util.Random;

public class BiogeographySolution {
    double[] habitat;
    double fitness;

    BiogeographySolution(int dimension){
        habitat = new double[dimension];

        Random rand = new Random();

        for(int i=0; i<dimension; i++){
            habitat[i] = rand.nextDouble(); //Initialize habitat randomly between 0 and 1

        }

        // Evaluate fitness based on the objective function
        fitness = evaluateFitness();
    }

    double evaluateFitness() {
        /*
        * Replace this with your objective function
        * Example: Minimize the square of the difference
        * from a target value (5 in this case)
        * */
        double targetValue = 5;
        double sum = 0;

        for(double x : habitat){
            sum += Math.pow(x - targetValue, 2);
        }

        return sum;
    }
}
