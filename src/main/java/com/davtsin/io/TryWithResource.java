package com.davtsin.io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TryWithResource {

    private static final String IO_INPUT_TXT = "input.txt";

    public static void main(String[] args) throws IOException {
        bufferedInput(IO_INPUT_TXT);
        input(IO_INPUT_TXT);
    }

    private static void bufferedInput(String ioInputTxt) throws IOException {
        long start = System.currentTimeMillis();
        try (BufferedInputStream io = new BufferedInputStream(
                TryWithResource.class.getResourceAsStream(ioInputTxt))) {
            while (io.available() > 0) {
                System.out.print(io.read());
            }
            System.out.println();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void input(String ioInputTxt) throws IOException {
        long start = System.currentTimeMillis();
        try (InputStream io = TryWithResource.class.getResourceAsStream(ioInputTxt)) {
            while (io.available() > 0) {
                System.out.print(io.read());
            }
            System.out.println();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
