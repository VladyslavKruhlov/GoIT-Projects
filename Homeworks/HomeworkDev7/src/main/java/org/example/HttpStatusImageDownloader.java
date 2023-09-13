package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    void downloadStatusImage(int code) throws IOException {

        try {
            String destinationPath = "src/main/java/org/example/image.jpg";
            HttpStatusChecker hsc = new HttpStatusChecker();

            URL url = new URL(hsc.getStatusImage(code));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {

                InputStream inputStream = connection.getInputStream();
                FileOutputStream outputStream = new FileOutputStream(destinationPath);

                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.close();
                inputStream.close();

                System.out.println("Download successful");
            } else {
                System.out.println("Error: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
