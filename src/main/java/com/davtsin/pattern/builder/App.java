package com.davtsin.pattern.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        var thief = new Hero.Builder("Thief", Profession.THIEF)
                .withWeapon(Weapon.KNIFE)
                .withHairColour(HairColour.WHITE)
                .build();

        logger.info(thief.toString());

        var robber = new Hero.Builder("Robber", Profession.ROBBER)
                .withArmour(Armour.KEVLAR_JACKET)
                .withHairColour(HairColour.BLACK)
                .withWeapon(Weapon.GUN)
                .build();

        logger.info(robber.toString());
    }
}
