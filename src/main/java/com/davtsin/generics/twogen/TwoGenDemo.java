package com.davtsin.generics.twogen;

class TwoGen<T, V> {
    T ob1;
    V ob2;

    public TwoGen(T ob1, V ob2) {
        this.ob1 = ob1;
        this.ob2 = ob2;
    }

    public T getOb1() {
        return ob1;
    }

    public V getOb2() {
        return ob2;
    }

    public void showTypes() {
        System.out.println("ob1: " + ob1.getClass().getName());
        System.out.println("ob2: " + ob2.getClass().getName());
    }
}

public class TwoGenDemo {
    public static void main(String[] args) {
        TwoGen<Integer, String> twoGen = new TwoGen<>(27, "Hello");
        twoGen.showTypes();
    }
}
