package Animals;

import contexts.context;

import java.util.Random;

public class Cat extends Pet {
    Random random = new Random();

    public Cat() {
        this.name = "Cat" + context.getName();
        this.cost = random.nextInt(100);
        this.breed = getBreed(random.nextInt(3));
        this.character = context.getCharacter(1 + random.nextInt(3));
        this.degreeOfPollution = (1 + random.nextInt(3)) * 10;
    }

    public Cat(String name, String breed, String character, String cost, String degreeOfPollution) {
        super(name, breed, character, cost, degreeOfPollution);
    }

    private static String getBreed(int random) {
        switch (random) {
            case 0:
                return Breed.NoWool.name();
            case 1:
                return Breed.WithWool.name();
            case 2:
                return Breed.WithWool.name();
            default:
                throw new IllegalArgumentException("Add breeds");
        }
    }

    private enum Breed {
        NoWool,
        WithWool
    }
}
