package BBO;

import java.util.Arrays;
import java.util.Random;

public class BBO {
    int populationSize;
    int maxGenerations;
    double migrationRate;
    int dimension;

    BiogeographySolution[] solutions;
    double[] migrationRates;
    int eliteCount;

    BBO(int populationSize, int maxGenerations, double migrationRate, int dimension){
        this.populationSize = populationSize;
        this.maxGenerations = maxGenerations;
        this.migrationRate = migrationRate;
        this.dimension = dimension;

        solutions = new BiogeographySolution[populationSize];
        migrationRates = new double[populationSize];
        eliteCount = (int) (0.1 * populationSize);  // 10% of the population are considered elite

        // Initialize solutions
        for (int i = 0; i < populationSize; i++) {
            solutions[i] = new BiogeographySolution(dimension);
            migrationRates[i] = this.migrationRate;
        }
    }

    void updateMigrationRates() {
        Arrays.sort(solutions, (a, b) -> Double.compare(a.fitness, b.fitness));

        for (int i = 0; i < populationSize; i++) {
            migrationRates[i] = migrationRate * (1 - (double) i / populationSize);
        }
    }

    void migrateSolutions() {
        Random rand = new Random();
        for (int i = eliteCount; i < populationSize; i++) {
            if (rand.nextDouble() < migrationRates[i]) {
                int sourceIndex = rand.nextInt(eliteCount);
                System.arraycopy(solutions[sourceIndex].habitat, 0, solutions[i].habitat, 0, dimension);
                solutions[i].fitness = solutions[i].evaluateFitness();
            }
        }
    }

    void optimize() {
        for (int generation = 0; generation < maxGenerations; generation++) {
            updateMigrationRates();
            migrateSolutions();

            // Optionally, you can print the best fitness at each generation
            Arrays.sort(solutions, (a, b) -> Double.compare(a.fitness, b.fitness));
            System.out.println("Generation " + (generation + 1) + ": Best Fitness = " + solutions[0].fitness);
        }

        // Print the final result
        Arrays.sort(solutions, (a, b) -> Double.compare(a.fitness, b.fitness));
        System.out.println("Optimization completed. Best fitness: " + solutions[0].fitness);
        System.out.print("Best habitat: " + Arrays.toString(solutions[0].habitat));
    }
}
