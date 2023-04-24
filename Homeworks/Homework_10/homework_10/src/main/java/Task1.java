import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args){

        File file = new File("C:\\GoIT-Projects\\Homeworks\\Homework_10\\homework_10\\files\\phones.txt");

        Pattern pattern = Pattern.compile("^\\(\\d{3}\\) \\d{3}-\\d{4}$");
        Pattern pattern1 = Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");

        if(file.exists()){
            try {
                InputStream fis = new FileInputStream(file);
                Scanner scanner = new Scanner(fis);

                while (scanner.hasNext()){
                    String phone = scanner.nextLine();
                    Matcher matcher = pattern.matcher(phone);
                    Matcher matcher1 = pattern1.matcher(phone);
                    if(matcher.matches() || matcher1.matches()){
                        System.out.println(phone);}
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}