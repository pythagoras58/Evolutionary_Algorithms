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

        return 0.0;
    }
}
