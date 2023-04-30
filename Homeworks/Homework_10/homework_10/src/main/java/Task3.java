
import java.io.*;
import java.util.*;

public class Task3 {
    public static void main(String[] args){
        Map<String, Integer> counter = new HashMap<>();
        try {
            File file = new File("homework_10/files/words.txt");
            InputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis);
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String [] splitLine = line.split(" ");
                for (int i=0; i<splitLine.length; i++){
                    if(!counter.containsKey(splitLine[i])){
                        counter.put(splitLine[i], 1);
                    }else {
                        counter.put(splitLine[i], counter.get(splitLine[i])+1);
                    }
                }
            }

        }catch (IOException e){
            e.printStackTrace();};


        System.out.println(counter.toString());

        Comparator<String> comparator = new Comparator<String>() {
            public int compare(String o1, String o2) {
                Integer value1 = counter.get(o1);
                Integer value2 = counter.get(o2);
                return value1.compareTo(value2) > 0 ? 1 : -1;
            }
        };
        Map<String, Integer> sort = new TreeMap<>(comparator.reversed());
        sort.putAll(counter);

        System.out.println(sort.toString());
    }
}