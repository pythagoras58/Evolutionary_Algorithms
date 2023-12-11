package PSO;

public class PSO {

    int swarmSize;
    int maxIterations;

    /*
    * c1  (cognitive coefficient): parameter controls the particle's
    *     tendency to be attracted
    *     to its own best-known position (personal best)
    *
    * c2 (social coefficient): parameter controls the particle's tendency to be
    *    attracted to the best-known position in the entire swarm (global best)
    *
    *
    * w (inertia weight):   It helps balance the exploration and
    *   exploitation phases of the algorithm
    * */
    double c1, c2, w;

    Particle[] particles;
    double[] globalBest;
    double globalBestFitness;

     PSO(int swarmSize, int maxIterations, double c1, double c2, double w, int dimension) {
        this.swarmSize = swarmSize;
        this.maxIterations = maxIterations;
        this.c1 = c1;
        this.c2 = c2;
        this.w = w;

        particles = new Particle[swarmSize];
        globalBest = new double[dimension];
        globalBestFitness = Double.POSITIVE_INFINITY;


        // particles initialization.
         for(int i=0; i<swarmSize; i++){
             particles[i] = new Particle(dimension);
         }
    }


    void updateGlobalBest(){
         for (Particle particle: particles){
             if(particle.fitness < globalBestFitness){
                 globalBestFitness = particle.fitness;
                 System.arraycopy(particle.position, 0, globalBest, 0, particle.position.length);
             }
         }
    }

    void updateParticles(){
         for(Particle particle: particles){
             for(int i=0; i<particle.position.length; i++){
                 // velocity updates
                 double r1 = Math.random();
                 double r2 = Math.random();

                 particle.velocity[i] = w * particle.velocity[i] +
                         c1 * r1 * (particle.personalBest[i] - particle.position[i]) +
                         c2 * r2 * (globalBest[i] - particle.position[i]);


                 // position update
                 particle.position[i] = particle.position[i] + particle.velocity[i];


                 // update personal best
                 if(particle.evaluateFitness() < particle.fitness){
                     particle.fitness = particle.evaluateFitness();
                     System.arraycopy(particle.position, 0, particle.personalBest, 0, particle.position.length);
                 }
             }
         }
    }

    void optimize(){
         for (int iteration = 0; iteration<maxIterations; iteration++){
             updateGlobalBest();
             updateParticles();

             // Optionally, you can print the best fitness at each iteration
             System.out.println("Iteration " + (iteration + 1) + ": Best Fitness = " + globalBestFitness);

         }

        // Print the final result
        System.out.println("Optimization completed. Best fitness: " + globalBestFitness);
        System.out.print("Best position: [");
        for (double value : globalBest) {
            System.out.print(value + " ");
        }
        System.out.println("]");
    }
}
