package PSO;

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

        for (int i=0; i<dimension;i++){
            // initialize postion and velocity.
            position[i] = rand.nextDouble()* 10; // Adjust the range based on your problem
            velocity[i] = rand.nextDouble()*2 - 1; // Adjust the range based on your problem

            personalBest[i] = position[i];
        }

        // Evaluate fitness based on the objective function

        fitness = evaluateFitness();

    }

    double evaluateFitness() {
        /*
        * Replace this with your objective function
        * Example: Minimize the square of the difference
        *  from a target value (5 in this case)
        * */

        double targetValue = 5;
        double sum = 0;

        for (double x : position){
            sum += Math.pow(x - targetValue, 2);
        }

        return sum;
    }

}
