package org.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Map<String, Integer> counter = new LinkedHashMap<>();
        try (
                InputStream fis = new FileInputStream("files/whoOwesMe.txt");
                Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] splitedLine = line.split(" ");
                String name = splitedLine[0];
                int money = Integer.parseInt(splitedLine[1]);
                System.out.println("name = " + name);
                System.out.println("monye = " + money);

//                if (personDebt.containsKey(name)) {
//                    int currDebt = personDebt.get(name);
//                    personDebt.put(name, currDebt + money);
//                } else {
//                    personDebt.put(name, money);
//                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
