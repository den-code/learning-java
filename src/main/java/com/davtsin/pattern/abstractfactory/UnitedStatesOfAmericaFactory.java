package com.davtsin.pattern.abstractfactory;

public class UnitedStatesOfAmericaFactory implements CountryFactory {
    @Override
    public President getPresident() {
        return new USPresident();
    }

    @Override
    public Army getArmy() {
        return new UsArmy();
    }

    @Override
    public Gold getGold() {
        return new USGold();
    }
}
