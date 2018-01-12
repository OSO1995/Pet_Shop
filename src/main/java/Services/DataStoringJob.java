package Services;

import Animals.Animal;
import contexts.context;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataStoringJob implements Runnable {
    public void save() {
        List<Animal> animalList = context.getStorage().getAnimals();
        try (BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter("C:\\storage.txt", false)))) {
            animalList.forEach(x -> {
                try {
                    bufferedWriter.write(x.toString() + "\r\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            save();
            context.getPrinting().save();//---------------------------------------------------------------------------------------------------------------
            System.out.println("----------------------Save in file!-----------------------");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
