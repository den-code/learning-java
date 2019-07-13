package com.davtsin.literals;

public class Literals {
    public static void main(String[] args) {
        float num = 1.0e2f;
        System.out.println("Float number: " + num);
        System.out.println(1.234e3 == 1.234 * 1e3f);
        System.out.println(1.234e3 == 1234);
        System.out.println(1.234e3 == 12345);
    }
}
