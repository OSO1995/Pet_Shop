package Services;

import Animals.*;
import contexts.context;

import java.util.Random;

public class RealLifeEmulator {
    private BuySellService buySellService = context.getBuySell();
    private DataStoringJob dataStoringJob = context.getDataStoring();
    private PollutionJob pollutionJob = context.getPollutionJob();
    private CleaningJob cleaningJob = context.getCleaningJob();

    public void start() throws Exception {
        Thread save10Second = new Thread(dataStoringJob);
        save10Second.start();
        Thread pollution = new Thread(pollutionJob);
        Thread cleaning = new Thread(cleaningJob);
        pollution.start();
        cleaning.start();
        while (true) {
            int code = new Random().nextInt(10);
            switch (code) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    buy(createAnimal());
                    break;
                case 6:
                    sell(getRandomAnimal());
                    break;
                case 7:
                    runAway(getRandomAnimal());
                    break;
                case 8:
            }
            Thread.sleep(1000);
        }
    }

    private void runAway(Animal randomAnimal) {
        context.getStorage().removeAnimals(randomAnimal);
        context.printInfo(getClass().getSimpleName() + ": Убежал зверь: " + randomAnimal.getName());
    }

    private void sell(Animal randomAnimal) {
        buySellService.sell(randomAnimal);
    }

    private void buy(Animal animal) {
        buySellService.buy(animal);
    }

    private Animal getRandomAnimal() throws Exception {
        int code = new Random().nextInt(1000) + 1;
        int size = context.getStorage().getAnimals().size();
        if (size > 0) {
            return context.getStorage().getAnimals().get(code % context.getStorage().getAnimals().size());
        } else {
            throw new Exception("В магазине нет животных.");
        }
    }

    private Animal createAnimal() {
        int code = new Random().nextInt(4) + 1;
        switch (code) {
            case 1:
                return new Cat();
            case 2:
                return new Dog();
            case 3:
                return new Wolf();
            case 4:
                return new Shark();
            default:
                throw new IllegalArgumentException("Ошибка при создании животного");
        }
    }
}
