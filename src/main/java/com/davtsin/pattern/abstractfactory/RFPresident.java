package com.davtsin.pattern.abstractfactory;

public class RFPresident implements President {

    private final static String DESCRIPTION = "Uh oh, ona utonula";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
