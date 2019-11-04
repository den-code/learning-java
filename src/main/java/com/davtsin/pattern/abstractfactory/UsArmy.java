package com.davtsin.pattern.abstractfactory;

public class UsArmy implements Army {

    private final static String DESCRIPTION = "Good army, strong army";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
