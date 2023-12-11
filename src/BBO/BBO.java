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
    }
}
