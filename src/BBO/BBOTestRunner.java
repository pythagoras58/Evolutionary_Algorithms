package BBO;

public class BBOTestRunner {
    public static void main(String[] args) {

        // Set BBO parameters
        int populationSize = 20;
        int maxGenerations = 100;
        double migrationRate = 0.1;
        int dimension = 5; // Adjust based on your problem

        // Create BBO instance
        BBO bbo = new BBO(populationSize, maxGenerations, migrationRate, dimension);

        // Run BBO optimization
        bbo.optimize();
    }
}
