package animals;

import contexts.Context;

import java.util.Random;

public class Wolf extends Predator {

  public Wolf() {
    this.name = "Wolf" + Context.getName();
    Random random = new Random();
    this.cost = random.nextInt(150);
    this.breed = getBreed(random.nextInt(2));
    this.character = Context.getCharacter(random.nextInt(3));
    this.degreeOfPollution = (1 + random.nextInt(3)) * 10;
  }

  public Wolf(String name, String breed, String character, String cost, String degreeOfPollution) {
    super(name, breed, character, cost, degreeOfPollution);
  }

  private static String getBreed(int random) {
    switch (random) {
      case 0:
        return Breed.MoreWool.name();
      case 1:
        return Breed.WithWool.name();
      default:
        throw new IllegalArgumentException("Add breeds");
    }
  }

  private enum Breed {
    WithWool,
    MoreWool
  }
}
