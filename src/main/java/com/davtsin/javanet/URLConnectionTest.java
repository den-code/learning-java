package com.davtsin.javanet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {

    public static void main(String[] args) throws Exception {
        URL url = new URL(URLTest.URL_ADDRESS);
        URLTest.printURLInfo(url);

        URLConnection urlConnection = url.openConnection();
        printURLConnectionInfo(urlConnection);
        printContent(urlConnection);
    }

    public static void printURLConnectionInfo(URLConnection urlConnection) throws IOException {
        System.out.println("Printing URLConnection info");
        System.out.println("getAllowUserInteraction(): " + urlConnection.getAllowUserInteraction());
        System.out.println("getConnectTimeout(): " + urlConnection.getConnectTimeout());
        System.out.println("getContentEncoding(): " + urlConnection.getContentEncoding());
        System.out.println("getContentLength(): " + urlConnection.getContentLength());
        System.out.println("getContentLengthLong(): " + urlConnection.getContentLengthLong());
        System.out.println("getContentType(): " + urlConnection.getContentType());
        System.out.println("getDate(): " + urlConnection.getDate());
        System.out.println("getDefaultUseCaches(): " + urlConnection.getDefaultUseCaches());
        System.out.println("getDoInput(): " + urlConnection.getDoInput());
        System.out.println("getDoOutput(): " + urlConnection.getDoOutput());
        System.out.println("getExpiration(): " + urlConnection.getExpiration());
        System.out.println("getHeaderFields(): " + urlConnection.getHeaderFields());
        System.out.println("getIfModifiedSince(): " + urlConnection.getIfModifiedSince());
        System.out.println("getLastModified(): " + urlConnection.getLastModified());
        System.out.println("getPermission(): " + urlConnection.getPermission());
        System.out.println("getReadTimeout(): " + urlConnection.getReadTimeout());
//        System.out.println("getRequestProperties(): " + urlConnection.getRequestProperties());
        System.out.println("getUseCaches(): " + urlConnection.getUseCaches());
        System.out.println();
    }

    public static void printContent(URLConnection urlConnection) throws IOException {
        System.out.println("Printing URLConnection content");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        System.out.println();
    }
}
