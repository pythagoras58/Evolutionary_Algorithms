package BBO;

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
}
