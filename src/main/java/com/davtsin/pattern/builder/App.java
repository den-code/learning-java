package com.davtsin.pattern.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static Logger logger = LoggerFactory.getLogger(com.davtsin.pattern.abstractfactory.App.class);

    public static void main(String[] args) {
        Hero thief = new Hero.Builder("Thief", Profession.THIEF)
                .withWeapon(Weapon.KNIFE)
                .withHairColour(HairColour.WHITE)
                .build();

        logger.info(thief.toString());

        Hero robber = new Hero.Builder("Robber", Profession.ROBBER)
                .withArmour(Armour.KEVLAR_JACKET)
                .withHairColour(HairColour.BLACK)
                .withWeapon(Weapon.GUN)
                .build();

        logger.info(robber.toString());
    }
}
