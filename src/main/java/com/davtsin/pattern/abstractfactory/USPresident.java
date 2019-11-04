package com.davtsin.pattern.abstractfactory;

public class USPresident implements President {

    private final static String DESCRIPTION = "Everything alright!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
