package ru.mirea.abstractFactoryExample;

public interface FurnitureFactory{
    public abstract Cupboard addCupboard();
    public abstract Chair addChair();
    public abstract Table addTable();
}
