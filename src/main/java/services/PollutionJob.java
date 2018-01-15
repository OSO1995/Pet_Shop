package services;

import animals.Animal;

import java.util.Random;

public class PollutionJob extends AbstractCleanPollutionJob {
  private final Random random = new Random();

  /**
   * функция загрязняющая животное на определенное значение
   *
   * @param x - зверь, над которым производится действие
   */
  void actionAnimal(Animal x) {
    x.setDegreeOfPollution(20 + random.nextInt(10));
  }
}
