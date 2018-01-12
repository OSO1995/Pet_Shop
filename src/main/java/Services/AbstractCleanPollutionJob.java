package Services;

import Animals.Animal;
import contexts.context;

public abstract class AbstractCleanPollutionJob implements Runnable {
    private PetShopStorage storage = context.getStorage();

    @Override
    public void run() {
        while (true) {
            storage.getAnimals().forEach(x -> actionAnimal(x));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    abstract void actionAnimal(Animal x);
}
