package Services;

import Animals.Animal;

import java.util.Random;

public class PollutionJob extends AbstractCleanPollutionJob {
    private Random random = new Random();

    void actionAnimal(Animal x) {
        x.setDegreeOfPollution(20 + random.nextInt(10));
    }
}
