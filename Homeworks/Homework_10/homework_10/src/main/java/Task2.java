import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.UserDTO;
import java.io.*;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException{

        List<Object> users = new ArrayList<>();

        try {
            File file = new File("homework_10/files/file.txt");
            InputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis);
            scanner.nextLine();
            UserDTO userDTO;

            while (scanner.hasNext()){

                String line = scanner.nextLine();
                String [] splitLine = line.split(" ");
                String getAge = splitLine[1];
                int age = Integer.parseInt (getAge);
                userDTO = new UserDTO(splitLine[0], age);
                users.add(userDTO);

            }

        }catch (IOException e){
            e.printStackTrace();};

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String toJson = gson.toJson(users);

        System.out.println(toJson);
    }
}
