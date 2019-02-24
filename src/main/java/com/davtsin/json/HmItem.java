package com.davtsin.json;

public class HmItem {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HmItem{" +
                "name='" + name + '\'' +
                '}';
    }
}
