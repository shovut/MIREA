package ru.mirea.abstractFactoryExample;

import java.util.ArrayList;
import java.util.List;

public abstract class Furniture {
    String name;
    List furnitures = new ArrayList();

    public String toString(){
        return "Furnitures: " + name + "\n" + furnitures;
    }
}

interface Cupboard {
    public abstract String toString();
}

interface Chair {
    public abstract String toString();
}

interface Table {
    public abstract String toString();
}

