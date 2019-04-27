package com.davtsin.generics.genmethod;

class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

class Util {
    static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }
}

public class GenMethodDemo {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("Hello", 1);
        Pair<String, Integer> p2 = new Pair<>("Hello", 1);
        Pair<String, Integer> p3 = new Pair<>("Hello", 2);

        System.out.println(Util.<String, Integer>compare(p1, p2));
        System.out.println(Util.<String, Integer>compare(p1, p3));
    }
}
