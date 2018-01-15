package services;

import animals.Animal;
import contexts.Context;

abstract class AbstractCleanPollutionJob implements Runnable {
  private final PetShopStorage storage = Context.getStorage();

  @Override
  public void run() {
    while (true) {
      storage.getAnimals().forEach(this::actionAnimal);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  abstract void actionAnimal(Animal x);
}
