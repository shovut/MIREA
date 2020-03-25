package ru.mirea.abstractFactoryExample;

public class PremiumFurnitureFactory implements FurnitureFactory{
    @Override
    public Cupboard addCupboard() {
        return new PremiumCupboard();
    }

    @Override
    public Chair addChair() {
        return new PremiumChair();
    }

    @Override
    public Table addTable() {
        return new PremiumTable();
    }
}
