package com.davtsin.pattern.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    private President president;
    private Army army;
    private Gold gold;

    public static void main(String[] args) {
        App app = new App();

        logger.info("Making RF country");
        app.createCountry(CountryFactoryMaker.createFactory(CountryEnum.RF));
        logger.info(app.getPresident().getDescription());
        logger.info(app.getArmy().getDescription());
        logger.info(app.getGold().getDescription());

        logger.info("Making USA country");
        app.createCountry(CountryFactoryMaker.createFactory(CountryEnum.USA));
        logger.info(app.getPresident().getDescription());
        logger.info(app.getArmy().getDescription());
        logger.info(app.getGold().getDescription());
    }

    public President getPresident() {
        return president;
    }

    public void setPresident(President president) {
        this.president = president;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
    }

    /*
     * Creating country
     * */
    private void createCountry(final CountryFactory countryFactory) {
        setPresident(countryFactory.getPresident());
        setArmy(countryFactory.getArmy());
        setGold(countryFactory.getGold());
    }

    public enum CountryEnum {
        RF, USA
    }

    public static class CountryFactoryMaker {
        public static CountryFactory createFactory(CountryEnum countryEnum) {
            switch (countryEnum) {
                case RF:
                    return new RussianFederationFactory();
                case USA:
                    return new UnitedStatesOfAmericaFactory();
                default:
                    throw new IllegalArgumentException("No such country");
            }
        }
    }
}
