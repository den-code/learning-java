package com.davtsin.javanet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketTest {
    private static final String HOST_NAME = "www.google.com";

    public static void main(String[] args) throws IOException, InterruptedException {

        try (Socket socket = new Socket(HOST_NAME, 80);
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("is connected: " + socket.isConnected());

            printWriter.println("GET / HTTP/1.1");
            printWriter.println("Host: " + HOST_NAME);
            printWriter.println("");
            printWriter.flush();

            String outStr;
            while ((outStr = bufferedReader.readLine()) != null) {
                System.out.println(outStr);
            }
            System.out.println();
            System.out.println("SUCCESS");
        }
    }
}
