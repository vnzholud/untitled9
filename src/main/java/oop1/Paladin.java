package oop1;

import oop1.models.HeroKingdom;

public class Paladin extends HeroKingdom {

    protected int damage;
    public Paladin(String name, int health, int energy, int power) {
        super(name, health, energy, power);
        this.damage = 0;
    }

    Paladin(String name, int health, int energy, int power, int damage) {
        super(name, health, energy, power);
        this.damage = damage;
    }

    @Override
    public void attack() {
        super.attack();
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void speak() {
        super.speak();
    }
}
