package services;

import animals.Animal;
import contexts.Context;

public class BuySellService {
  private final PetShopStorage petStorage = Context.getStorage();
  private SearchService searchService = Context.getSearch();
  private int money = Integer.MAX_VALUE / 2;

  public void buy(Animal animal) {
    if (haveMoney(animal.getCost())) {
      petStorage.addAnimals(animal);
      Context.printInfo(getClass().getSimpleName() + ": Куплена зверушка: " + animal.getName() + " за " + animal.getCost());
    } else {
      Context.printInfo(getClass().getSimpleName() + ": Недостаточно денег");
    }
  }

  public void sell(Animal animal) {
    money += animal.getCost();
    petStorage.removeAnimals(animal);
    Context.printInfo(getClass().getSimpleName() + ": Продана зверушка: " + animal.getName() + " за " + animal.getCost());
  }

  private boolean haveMoney(Integer cost) {
    return (money - cost) > 0 ? true : false;
  }
}
