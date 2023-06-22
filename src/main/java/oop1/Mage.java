package oop1;

import oop1.models.HeroKingdom;

public class Mage extends HeroKingdom {

    public Mage(String name, int health, int energy, int power) {
        super(name, health, energy, power);
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
