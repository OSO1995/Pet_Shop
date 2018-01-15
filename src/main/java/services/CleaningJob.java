package services;

import animals.Animal;

import java.util.Random;

public class CleaningJob extends AbstractCleanPollutionJob {
  private final Random random = new Random();

  /**
   * функция очищающая животное на определенное значение
   *
   * @param x - зверь, над которым производится действие
   */
  void actionAnimal(Animal x) {
    x.setDegreeOfPollution((20 + random.nextInt(10)) * (-1));
  }
}
