package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpImageStatusCli {
    private static final String TEST_URL = "https://http.cat";
    void askStatus() throws IOException, IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter HTTP status code ");
        try {
            while (in.hasNext()){


                if(in.hasNextInt()){
                    int code = in.nextInt();
                    try {
                        URL url = new URL(TEST_URL+"/"+code+".jpg");

                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        int responseCode = connection.getResponseCode();

                        if(responseCode==404){
                            System.out.println("There is not image for HTTP status "+code);
                            System.out.print("Enter HTTP status code ");
                        }
                        else {
                            HttpStatusImageDownloader hid = new HttpStatusImageDownloader();
                            hid.downloadStatusImage(code);
                            break;
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Please enter valid number");
                    in.next();
                    System.out.print("Enter HTTP status code ");
                }
            }
        in.close();
        System.out.println("Program closed");
        } catch (RuntimeException e) {
            throw new RuntimeException("Program closed");
        }
    }
}
