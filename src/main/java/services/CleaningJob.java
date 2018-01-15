package services;

import animals.Animal;

import java.util.Random;

public class CleaningJob extends AbstractCleanPollutionJob {
  private final Random random = new Random();

  void actionAnimal(Animal x) {
    x.setDegreeOfPollution((20 + random.nextInt(10)) * (-1));
  }
}
