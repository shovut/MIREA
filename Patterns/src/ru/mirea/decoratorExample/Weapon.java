package ru.mirea.decoratorExample;

public class Weapon extends Decorator{
    Hero hero;

    public Weapon(Hero hero) {
        this.hero = hero;
    }

    @Override
    public String getInfo() {
        return hero.getInfo() + " have weapon";
    }

    @Override
    public int getLevel() {
        return hero.getLevel() + 3;
    }
}
