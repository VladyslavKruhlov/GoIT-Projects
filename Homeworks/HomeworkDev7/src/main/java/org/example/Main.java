package org.example;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        HttpStatusImageDownloader hid = new HttpStatusImageDownloader();
        //hid.downloadStatusImage(1000);
        HttpImageStatusCli hisc = new HttpImageStatusCli();
        hisc.askStatus();
    }
}