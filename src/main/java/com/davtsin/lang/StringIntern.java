package com.davtsin.lang;

public class StringIntern {

    public static void main(String[] args) {

        // with intern()
        System.out.println("With intern()");
        String str1 = "hello";
        String str2 = str1.intern();
        str1 = null;
        System.out.println(str1);
        System.out.println(str2);
        System.out.println();

        // without intern
        System.out.println("Without intern()");
        String str3 = "hello";
        String str4 = str3;
        str3 = null;
        System.out.println(str3);
        System.out.println(str4);
        System.out.println();

        // not a String
        System.out.println("Not a String");
        Object a = new Object();
        Object b = a;
        a = null;
        System.out.println(a);
        System.out.println(b);
        System.out.println();
    }
}
