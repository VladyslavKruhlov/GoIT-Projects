package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    private static final String TEST_URL = "https://http.cat";
    String getStatusImage(int code) throws IOException {

        URL url = new URL(TEST_URL+"/"+code+".jpg");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if(responseCode==404){
            throw new IOException("Not found page with your status code! Please use another code");
        } else {
            return url.toString();
        }
    }
}
