package ru.mirea.decoratorExample;

public abstract class Hero {
    String name = "Unnamed Hero";
    public String getInfo(){
        return name;
    }
    public abstract int getLevel();
}

abstract class Decorator extends Hero{
    public abstract String getInfo();
}

