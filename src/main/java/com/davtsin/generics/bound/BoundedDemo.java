package com.davtsin.generics.bound;


class Stats<T extends Number> {
    private T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    public double getAverage() {
        double sum = 0;
        for (T num : nums) {
            sum += num.doubleValue();
        }
        return sum / nums.length;
    }
}

public class BoundedDemo {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5};
        Stats<Integer> stats = new Stats<>(integers);
        System.out.println(stats.getAverage());

        // compile error
//        String[] strings = {"henry", "ford"};
//        stats = new Stats<String>(strings);
    }
}
