package abstractFactoryExample;

public class CommonFurniture extends Furniture{
    public CommonFurniture(FurnitureFactory furnitureFactory) {
        name = "Premium";
        furnitures.add(furnitureFactory.addCupboard());
        furnitures.add(furnitureFactory.addChair());
        furnitures.add(furnitureFactory.addTable());
    }
}

class CommonCupboard implements Cupboard{
    @Override
    public String toString() {
        return "Common Cupboard";
    }
}

class CommonChair implements Chair{
    @Override
    public String toString() {
        return "Common Chair";
    }
}

class CommonTable implements Table{
    @Override
    public String toString() {
        return "Common Table";
    }
}


