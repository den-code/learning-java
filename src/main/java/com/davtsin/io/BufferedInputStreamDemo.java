package com.davtsin.io;

// Use buffered input.
// This program uses try-with-resources. It requires JDK 7 or later.

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
    private static Logger logger = LoggerFactory.getLogger(BufferedInputStreamDemo.class);

    public static void main(String[] args) {
        String s = "This is a &copy; copyright symbol " +
                "but this is &copy not.\n";
        byte[] buf = s.getBytes();

        ByteArrayInputStream in = new ByteArrayInputStream(buf);
        int c;
        boolean marked = false;
        StringBuilder sb = new StringBuilder();

        // Use try-with-resources to manage the file.
        try (BufferedInputStream f = new BufferedInputStream(in)) {
            while ((c = f.read()) != -1) {
                switch (c) {
                    case '&':
                        if (!marked) {
                            f.mark(32);
                            marked = true;
                        } else {
                            marked = false;
                        }
                        break;
                    case ';':
                        if (marked) {
                            marked = false;
                            sb.append("(c)");
                        } else
                            sb.append((char) c);
                        break;
                    case ' ':
                        if (marked) {
                            marked = false;
                            f.reset();
                            sb.append("&");
                        } else
                            sb.append((char) c);
                        break;
                    default:
                        if (!marked)
                            sb.append((char) c);
                        break;
                }
            }
        } catch (IOException e) {
            logger.error("I/O Error: {}", e);
        }

        logger.info("{}", sb);
    }
}
