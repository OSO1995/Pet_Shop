package contexts;

import java.util.Date;

import services.*;


public class Context {


  public static String getName() {
    Integer i = (new Date()).hashCode() + (int) (Math.random() * 10);
    return i.toString();
  }

  public static String getCharacter(int i) {
    switch (i) {
      case 0:
        return Characters.iEatYou;
      case 1:
        return Characters.iHateYou;
      case 2:
        return Characters.normal;
      case 3:
        return Characters.iLikeYou;
      case 4:
        return Characters.iLoveYou;
      default:
        return "UnknownCharacter";
    }
  }

  public static PetShopStorage getStorage() {
    return SingletonPetShopStorage.petShopStorageInstance;
  }

  public static BuySellService getBuySell() {
    return SingletonBuySellService.buySellServiceInstance;
  }

  public static RealLifeEmulator getEmulator() {
    return SingletonRealLifeEmulator.realLifeEmulatorInstance;
  }

  public static SearchService getSearch() {
    return SingletonSearchService.searchServiceInstance;
  }

  public static DataStoringJob getDataStoring() {
    return SingletonDataStoringJob.dataStoringJobInstance;
  }

  public static PrintingService getPrinting() {
    return SingletonPrintingService.printingServiceInstance;
  }

  public static PollutionJob getPollutionJob() {
    return SingletonPollutionJob.pollutionJobInstance;
  }

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

  public static void printInfo(String s) {
    getPrinting().saveInfo(s);
    //System.out.println(s);
  }

}
