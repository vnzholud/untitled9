package oop1.models;

public class HeroKingdom extends Object{
    protected final int myInt = 0;

    protected int health;
    protected int energy;
    protected int power;
    protected String name;

    protected HeroKingdom(String name, int health, int energy, int power) {
        this.name = name;
        this.health = health;
        this.energy = energy;
        this.power = power;
    }

    public void attack() {
        System.out.println(name + " attack " + power);
    }

    public void run() {
        System.out.println(name + " run");
    }

    public void speak() {
//        System.out.println(name + " speak");
        System.out.println("I'm hero");
    }

//    abstract protected void heal(int hp);

}
