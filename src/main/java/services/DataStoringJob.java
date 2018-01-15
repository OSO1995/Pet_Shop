package services;

import animals.Animal;
import contexts.Context;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataStoringJob implements Runnable {

  private void save() {
    List<Animal> animalList = Context.getStorage().getAnimals();
    try (BufferedWriter bufferedWriter = new BufferedWriter(
        (new FileWriter("C:\\storage.txt", false)))) {
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
  /**
   * функция сохраняющая животных в .txt файл
   */
  public void run() {
    while (true) {
      save();
      Context.getPrinting().save();
      System.out.println("----------------------Save in file!-----------------------");
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
