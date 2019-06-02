package com.davtsin.generics.genbasic;

class Gen<T> {

    T ob;

    Gen(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }

    void showType() {
        System.out.println("Типом является: " + ob.getClass().getName());
    }

}

class GenObj {

    Object ob;

    GenObj(Object o) {
        ob = o;
    }

    Object getOb() {
        return ob;
    }

    void showType() {
        System.out.println("Типом является: " + ob.getClass().getName());
    }

}

public class GenDemo {
    public static void main(String[] args) {
        Gen<String> gen = new Gen<>("Тест");

        gen.showType();

        String value = gen.getOb();

        System.out.println(value);



        System.out.println("---");

        GenObj genObj = new GenObj("Hello");

        genObj.showType();

        value = (String) genObj.getOb();

        System.out.println(value);




        System.out.println("---");

        Object object = "Hello";
        System.out.println(object.getClass().getName());
        boolean bool = object instanceof String;
        System.out.println(bool);
    }
}
