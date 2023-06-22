package oop1;

import oop1.models.HeroKingdom;

public class Archer extends HeroKingdom {

    Archer(String name, int health, int energy, int power) {
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
    public void speak(){
        System.out.println(name + " speak");
    }

//    @Override
//    public void heal(int hp) {
//        this.health += hp;
//    }

}
