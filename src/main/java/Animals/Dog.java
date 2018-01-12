package Animals;

import contexts.context;

import java.util.Random;
import java.util.UUID;

public class Dog extends Pet {
    Random random = new Random();

    public Dog() {
        this.name = "Dog" + context.getName();
        this.cost = 10 + random.nextInt(100);
        this.breed = getBreed(random.nextInt(2));
        this.character = context.getCharacter(2 + random.nextInt(3));
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

