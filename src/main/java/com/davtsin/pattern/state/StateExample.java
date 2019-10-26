package com.davtsin.pattern.state;

public class StateExample {

    public static void main(String[] args) {
        StateContext context = new StateContext();
        context.heat();
        context.heat();
        context.heat();
        context.freeze();
        context.freeze();
        context.freeze();
    }
}