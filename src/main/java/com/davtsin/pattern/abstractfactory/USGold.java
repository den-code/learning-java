package com.davtsin.pattern.abstractfactory;

public class USGold implements Gold {

    private final static String DESCRIPTION = "Many many gold";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
