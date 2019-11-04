package com.davtsin.pattern.abstractfactory;

public class RussianFederationFactory implements CountryFactory {
    @Override
    public President getPresident() {
        return new RFPresident();
    }

    @Override
    public Army getArmy() {
        return new RFArmy();
    }

    @Override
    public Gold getGold() {
        return new RFGold();
    }
}
