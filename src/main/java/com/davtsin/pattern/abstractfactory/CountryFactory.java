package com.davtsin.pattern.abstractfactory;

public interface CountryFactory {

    President getPresident();

    Army getArmy();

    Gold getGold();
}
