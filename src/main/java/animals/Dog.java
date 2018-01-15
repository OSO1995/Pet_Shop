package animals;

import contexts.Context;

import java.util.Random;

public class Dog extends Pet {

  public Dog() {
    this.name = "Dog" + Context.getName();
    Random random = new Random();
    this.cost = 10 + random.nextInt(100);
    this.breed = getBreed(random.nextInt(2));
    this.character = Context.getCharacter(2 + random.nextInt(3));
    this.degreeOfPollution = (1 + random.nextInt(3)) * 10;
  }

  public Dog(String name, String breed, String character, String cost, String degreeOfPollution) {
    super(name, breed, character, cost, degreeOfPollution);
  }

  private static String getBreed(int random) {
    switch (random) {
      case 0:
        return Breed.BigDog.name();
      case 1:
        return Breed.SmallDog.name();
      default:
        throw new IllegalArgumentException("Add breeds");
    }
  }

  private enum Breed {
    BigDog,
    SmallDog
  }
}

