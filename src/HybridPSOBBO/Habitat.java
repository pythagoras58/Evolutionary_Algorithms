package HybridPSOBBO;

import java.util.Random;

public class Habitat {
    double[] habitat;
    double fitness;

    Habitat(int dimension){
        habitat = new double[dimension];
        Random rand = new Random();
        for (int i = 0; i < dimension; i++) {
            habitat[i] = rand.nextDouble(); // Initialize habitat randomly between 0 and 1
        }

        fitness = evaluateFitness();
    }

    double evaluateFitness() {
        double targetValue = 5;
        double sum = 0;
        for (double x : habitat) {
            sum += Math.pow(x - targetValue, 2);
        }

        return sum;
    }
}
