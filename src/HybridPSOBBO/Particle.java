package HybridPSOBBO;

import java.util.Random;

public class Particle {
    double[] position;
    double[] velocity;
    double[] personalBest;
    double fitness;

    Particle(int dimension){
        position = new double[dimension];
        velocity = new double[dimension];
        personalBest = new double[dimension];

        Random rand = new Random();
        for (int i = 0; i < dimension; i++) {
            position[i] = rand.nextDouble() * 10; // Adjust the range based on your problem
            velocity[i] = rand.nextDouble() * 2 - 1; // Adjust the range based on your problem
            personalBest[i] = position[i];
        }

        fitness = evaluateFitness();
    }

    double evaluateFitness() {
        double targetValue = 5;
        double sum = 0;

        for(double x: position){
            sum += Math.pow(x - targetValue, 2);
        }
        return sum;
    }
}
