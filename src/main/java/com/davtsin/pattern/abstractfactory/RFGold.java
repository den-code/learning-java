package com.davtsin.pattern.abstractfactory;

public class RFGold implements Gold {

    private final static String DESCRIPTION = "Deneg net, no vy derjites...";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
