package oop1;

import oop1.models.HeroKingdom;

public class Titan extends HeroKingdom {
    public Titan(String name, int health, int energy, int power, int damage) {
        super(name, health, energy, power);
    }

    void bigAttack() {
        System.out.println(name + " has big attack");
    }

    public void speak(){

        System.out.println(name + "ahahahaahahahahahha");
    }



    @Override
    public void attack() {
        super.attack();
    }

    @Override
    public void run() {
        super.run();
    }


}
