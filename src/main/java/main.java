import contexts.context;

import java.util.Random;

public class main {
    static Random random = new Random(10);

    public static void main(String[] args) {
        try {
            context.getEmulator().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}//eqals сделать, косяк при загрузке животных из файла
