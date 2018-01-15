package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PrintingService {
  private final ArrayList<String> info = new ArrayList<>();

  /**
   * функция добавляющая информацию о совершенных действиях к списку информации
   *
   * @param s - сохраняемая строка
   */
  public void saveInfo(String s) {
    info.add(s);
  }

  /**
   * функция сохраняющая информацию о покупках в файл
   */
  public void save() {
    try (BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter("C:\\BuySell.txt", false)))) {
      info.forEach(x -> {
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

  /**
   * функция выводящая в консоль список совершенных операций
   */
  public void printInfo() {
    if (info.size() > 0) {
      info.forEach(x -> System.out.println(x));
    } else {
      System.out.println("Еще не совершено ни 1 операции.");
    }
  }
}
