package ru.mirea.abstractFactoryExample;

public class CommonFurnitureFactory implements FurnitureFactory{
    @Override
    public Cupboard addCupboard() {
        return new CommonCupboard();
    }

    @Override
    public Chair addChair() {
        return new CommonChair();
    }

    @Override
    public Table addTable() {
        return new CommonTable();
    }
}
