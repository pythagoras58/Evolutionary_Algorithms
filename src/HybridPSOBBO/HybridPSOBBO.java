package HybridPSOBBO;

public class HybridPSOBBO {
    int particleCount;
    int habitatCount;
    int maxIterations;
    double w, c1, c2, migrationRate;

    Particle[] particles;
    Habitat[] habitats;
    double[] globalBest;
    double globalBestFitness;


    HybridPSOBBO(int particleCount, int habitatCount, int maxIterations, double w, double c1, double c2, double migrationRate, int dimension){
        this.particleCount = particleCount;
        this.habitatCount = habitatCount;
        this.maxIterations = maxIterations;
        this.w = w;
        this.c1 = c1;
        this.c2 = c2;
        this.migrationRate = migrationRate;

        particles = new Particle[particleCount];
        habitats = new Habitat[habitatCount];
        globalBest = new double[dimension];
        globalBestFitness = Double.POSITIVE_INFINITY;

        // PSO particle check
        for (int i = 0; i < particleCount; i++) {
            particles[i] = new Particle(dimension);
        }

        // BBO habitat check
        for (int i = 0; i < habitatCount; i++) {
            habitats[i] = new Habitat(dimension);
        }
    }


    // update the GlobalBest
    void updateGlobalBest(){
        for (Particle particle : particles) {
            if (particle.fitness < globalBestFitness) {
                globalBestFitness = particle.fitness;
                System.arraycopy(particle.position, 0, globalBest, 0, particle.position.length);
            }
        }

        for (Habitat habitat : habitats) {
            if (habitat.fitness < globalBestFitness) {
                globalBestFitness = habitat.fitness;
                System.arraycopy(habitat.habitat, 0, globalBest, 0, habitat.habitat.length);
            }
        }
    }
}
