package com.davtsin.javanet;

import java.io.InputStream;
import java.net.URL;

public class URLTest {
    public static final String URL_ADDRESS = "http://www.google.com";

    public static void printURLInfo(URL url) throws Exception {
        System.out.println("Printing URL info:");
        System.out.println("toString(): " + url.toString());
        System.out.println("toURI(): " + url.toURI());
        System.out.println("getAuthority(): " + url.getAuthority());

        InputStream inputStream = (InputStream) url.getContent();
        System.out.println("getContent(): " + inputStream);
        inputStream.close();

        System.out.println("getDefaultPort(): " + url.getDefaultPort());
        System.out.println("getFile(): " + url.getFile());
        System.out.println("getHost(): " + url.getHost());
        System.out.println("getPath(): " + url.getPath());
        System.out.println("getProtocol(): " + url.getProtocol());
        System.out.println("getQuery(): " + url.getQuery());
        System.out.println("getRef(): " + url.getRef());
        System.out.println("getUserInfo(): " + url.getUserInfo());
        System.out.println("toExternalForm(): " + url.toExternalForm());
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL(URL_ADDRESS);

        printURLInfo(url);
    }
}
