package Services;

import contexts.context;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PrintingService {
    private ArrayList<String> info = new ArrayList<>();

    public void saveInfo(String s) {
        info.add(s);
    }

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

    public void printInfo() {
        if (info.size() > 0) {
            info.forEach(x -> System.out.println(x));
        } else {
            System.out.println("Еще не совершено ни 1 операции.");
        }
    }
}
