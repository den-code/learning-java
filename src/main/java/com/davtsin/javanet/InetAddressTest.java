package com.davtsin.javanet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {

    private final static String HOST_NAME = "www.google.com";

    private static void printAddressInfo(InetAddress inetAddress) {
        System.out.println("toString(): " + inetAddress);
        System.out.println("getAddress() []: " + Arrays.toString(inetAddress.getAddress()));
        System.out.println("getCanonicalHostName(): " + inetAddress.getCanonicalHostName());
        System.out.println("getHostAddress(): " + inetAddress.getHostAddress());
        System.out.println("getHostName(): " + inetAddress.getHostName());
        System.out.println();
    }

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
//        printAddressInfo(address);

        address = InetAddress.getByName(HOST_NAME);
//        printAddressInfo(address);

        InetAddress[] addresses = InetAddress.getAllByName(HOST_NAME);
        Arrays.stream(addresses).forEach(InetAddressTest::printAddressInfo);
    }
}
