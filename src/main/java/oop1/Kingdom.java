package oop1;

public class Kingdom {

    public static void main(String[] args) {

        Archer archer = new Archer("Archer",100,200,50);
        Paladin paladin = new Paladin("Paladin", 500, 100, 150);
        Mage mage = new Mage("Mage", 50, 1000, 200);
        Titan titan = new Titan("Titan", 1000, 1000, 1000, 500);


        paladin.attack();
        titan.bigAttack();
        titan.speak();
    }


}
