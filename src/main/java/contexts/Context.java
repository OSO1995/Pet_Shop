package contexts;

import java.util.Date;

import services.*;


public class Context {

  /**
   * Функция генерирующая имя животного
   *
   * @return уникальное значение которое будет использоваться в имени
   */
  public static String getName() {
    Integer i = (new Date()).hashCode() + (int) (Math.random() * 10);
    return i.toString();
  }

  /**
   * Функция определяющая характер зверя
   *
   * @param i - случайное значение зависящее от места вызова функции
   * @return характер зверя
   */
  public static String getCharacter(int i) {
    switch (i) {
      case 0:
        return Characters.I_EAT_YOU;
      case 1:
        return Characters.I_HATE_YOU;
      case 2:
        return Characters.NORMAL;
      case 3:
        return Characters.I_LIKE_YOU;
      case 4:
        return Characters.I_LOVE_YOU;
      default:
        return "UnknownCharacter";
    }
  }

  /**
   * Функция для поддержания singleton
   *
   * @return instance требуемого класса
   */
  public static PetShopStorage getStorage() {
    return SingletonPetShopStorage.petShopStorageInstance;
  }

  /**
   * Функция для поддержания singleton
   *
   * @return instance требуемого класса
   */
  public static BuySellService getBuySell() {
    return SingletonBuySellService.buySellServiceInstance;
  }

  /**
   * Функция для поддержания singleton
   *
   * @return instance требуемого класса
   */
  public static RealLifeEmulator getEmulator() {
    return SingletonRealLifeEmulator.realLifeEmulatorInstance;
  }

  /**
   * Функция для поддержания singleton
   *
   * @return instance требуемого класса
   */
  public static SearchService getSearch() {
    return SingletonSearchService.searchServiceInstance;
  }

  /**
   * Функция для поддержания singleton
   *
   * @return instance требуемого класса
   */
  public static DataStoringJob getDataStoring() {
    return SingletonDataStoringJob.dataStoringJobInstance;
  }

  /**
   * Функция для поддержания singleton
   *
   * @return instance требуемого класса
   */
  public static PrintingService getPrinting() {
    return SingletonPrintingService.printingServiceInstance;
  }

  /**
   * Функция для поддержания singleton
   *
   * @return instance требуемого класса
   */
  public static PollutionJob getPollutionJob() {
    return SingletonPollutionJob.pollutionJobInstance;
  }

  /**
   * Функция для поддержания singleton
   *
   * @return instance требуемого класса
   */
  public static CleaningJob getCleaningJob() {
    return SingletonCleaningJob.cleaningJobInstance;
  }

  private static class SingletonPetShopStorage {
    private final static PetShopStorage petShopStorageInstance = new PetShopStorage();
  }

  private static class SingletonBuySellService {
    private final static BuySellService buySellServiceInstance = new BuySellService();
  }

  private static class SingletonRealLifeEmulator {
    private final static RealLifeEmulator realLifeEmulatorInstance = new RealLifeEmulator();
  }

  private static class SingletonSearchService {
    private final static SearchService searchServiceInstance = new SearchService();
  }

  private static class SingletonDataStoringJob {
    private final static DataStoringJob dataStoringJobInstance = new DataStoringJob();
  }

  private static class SingletonPrintingService {
    private final static PrintingService printingServiceInstance = new PrintingService();
  }

  private static class SingletonPollutionJob {
    private final static PollutionJob pollutionJobInstance = new PollutionJob();
  }

  private static class SingletonCleaningJob {
    private final static CleaningJob cleaningJobInstance = new CleaningJob();
  }

  /**
   * функция сохранения информации
   *
   * @param s - строка требующая сохранения
   */
  public static void printInfo(String s) {
    getPrinting().saveInfo(s);
    //System.out.println(s);
  }

}
