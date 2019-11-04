package com.davtsin.pattern.abstractfactory;

public class RFArmy implements Army {

    private final static String DESCRIPTION = "Ubegai! Seichas svoi sklad rvanet!";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
