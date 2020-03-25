package ru.mirea.abstractFactoryExample;

public class PremiumFurniture extends Furniture{
    public PremiumFurniture(FurnitureFactory furnitureFactory) {
        name = "Premium";
        furnitures.add(furnitureFactory.addCupboard());
        furnitures.add(furnitureFactory.addChair());
        furnitures.add(furnitureFactory.addTable());
    }
}

class PremiumCupboard implements Cupboard{
    @Override
    public String toString() {
        return "Premium Cupboard";
    }
}

class PremiumChair implements Chair{
    @Override
    public String toString() {
        return "Premium Chair";
    }
}

class PremiumTable implements Table{
    @Override
    public String toString() {
        return "Premium Table";
    }
}
