package com.davtsin.javanet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnectionTest {

    public static void main(String[] args) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(URLTest.URL_ADDRESS).openConnection();
        pringHttpUrlConnectionInfo(connection);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
        }

        connection.disconnect();
    }

    public static void pringHttpUrlConnectionInfo(HttpURLConnection connection) throws IOException {
        URLConnectionTest.printURLConnectionInfo(connection);
        System.out.println("Printing HttpURLConnection info");
        System.out.println("getRequestMethod(): " + connection.getRequestMethod());
        System.out.println("getResponseMessage(): " + connection.getResponseMessage());
        System.out.println("getPermission(): " + connection.getPermission());
        System.out.println("getResponseCode(): " + connection.getResponseCode());
    }
}
