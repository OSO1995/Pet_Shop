package animals;

abstract class Pet extends AbstractAnimal {
  Pet(String name, String breed, String character, String cost, String degreeOfPollution) {
    super(name, breed, character, cost, degreeOfPollution);
  }

  Pet() {
  }
}
