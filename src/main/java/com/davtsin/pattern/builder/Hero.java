package com.davtsin.pattern.builder;

public class Hero {
    private final String name;
    private final Profession profession;
    private final HairColour hairColour;
    private final Armour armour;
    private final Weapon weapon;

    private Hero(Builder builder) {
        this.name = builder.name;
        this.profession = builder.profession;
        this.hairColour = builder.hairColour;
        this.armour = builder.armour;
        this.weapon = builder.weapon;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", profession=" + profession +
                ", hairColour=" + hairColour +
                ", armour=" + armour +
                ", weapon=" + weapon +
                '}';
    }

    public static class Builder {
        private final String name;
        private final Profession profession;

        // optional params, init with default values
        private HairColour hairColour = HairColour.BLACK;
        private Armour armour = Armour.CLOTHES;
        private Weapon weapon = Weapon.HANDS;

        public Builder(String name, Profession profession) {
            this.name = name;
            this.profession = profession;

            if (name == null || profession == null) {
                throw new IllegalArgumentException("Name and profession must not be null");
            }
        }

        public Builder withHairColour(HairColour hairColour) {
            this.hairColour = hairColour;
            return this;
        }

        public Builder withArmour(Armour armour) {
            this.armour = armour;
            return this;
        }

        public Builder withWeapon(Weapon weapon) {
            this.weapon = weapon;
            return this;
        }

        public Hero build() {
            return new Hero(this);
        }
    }
}
