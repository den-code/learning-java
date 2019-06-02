package com.davtsin.security;

import org.apache.commons.codec.binary.Hex;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digest {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, URISyntaxException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        byte[] input = Files.readAllBytes(Paths.get(Digest.class.getResource("input.txt").toURI()));

        byte[] hash = messageDigest.digest(input);

        String d = "";
        for (int i = 0; i < hash.length; i++) {
            int v = hash[i] & 0xFF;
            if (v < 16) d += "0";
            d += Integer.toString(v, 16).toUpperCase() + " ";
        }

        System.out.println(d);
        System.out.println(Hex.encodeHexString(hash));
    }
}
