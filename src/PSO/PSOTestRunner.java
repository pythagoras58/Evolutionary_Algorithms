package PSO;

public class PSOTestRunner {

    public static void main(String[] args) {

        // Set PSO parameters
        int swarmSize = 20;
        int maxIterations = 100;
        double c1 = 2.0;
        double c2 = 2.0;
        double w = 0.5;
        int dimension = 5; // Adjust based on your problem

        // Create PSO instance
        PSO pso = new PSO(swarmSize, maxIterations, c1, c2, w, dimension);

        // Run PSO optimization
        pso.optimize();
    }
}
