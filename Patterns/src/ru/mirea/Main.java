package ru.mirea;
import ru.mirea.abstractFactoryExample.*;
import ru.mirea.builderExample.*;
import ru.mirea.decoratorExample.*;
import ru.mirea.facadeExample.*;
import ru.mirea.strategyExample.*;

public class Main {

    public static void main(String[] args) {

        // Builder example
        System.out.println("Builder example");

        Cat myCat = new Cat.Builder()
                .withName("Kotya")
                .withKind("Blohastik")
                .withAge(4)
                .withWeight(6)
                .withColors("Grey")
                .build();
        System.out.println(myCat);

        System.out.println();

        // Facade example
        System.out.println("Facade example");

        EnergyPower energyPower = new EnergyPower();
        Monitor monitor = new Monitor();
        SystemUnit systemUnit = new SystemUnit();

        ComputerSystemInterface computerSystemInterface =
                new ComputerSystemInterface(energyPower, monitor, systemUnit);

        computerSystemInterface.start();
        systemUnit.someMethod();
        computerSystemInterface.off();

        System.out.println();

        // Communication example
        System.out.println("Communication example");

        Smartphone smartphoneLTE = new SmartphoneWithLTE();
        smartphoneLTE.communicationTest();
        Smartphone smartphoneWIFI = new SmartphoneWithWIFI();
        smartphoneWIFI.communicationTest();

        System.out.println();

        // Abstract Factory example
        System.out.println("Abstract Factory example");

        FurnitureFactory myPremiumFactory = new PremiumFurnitureFactory();
        FurnitureFactory myCommonFactory = new CommonFurnitureFactory();

        Furniture myPremiumFurniture = new PremiumFurniture(myPremiumFactory);
        Furniture myCommonFurniture = new CommonFurniture(myCommonFactory);

        System.out.println(myPremiumFurniture);
        System.out.println(myCommonFurniture);

        System.out.println();

        // Strategy example
        System.out.println("Strategy example");

        Hero hero1 = new JumpHero();
        System.out.println(hero1.getInfo());
        System.out.println(hero1.getLevel());

        hero1 = new Weapon(hero1);
        System.out.println(hero1.getInfo());
        System.out.println(hero1.getLevel());

        hero1 = new Armor(hero1);
        System.out.println(hero1.getInfo());
        System.out.println(hero1.getLevel());

        Hero hero2 = new Weapon(new Armor(new StrongHero()));
        System.out.println(hero2.getInfo());
        System.out.println(hero2.getLevel());

        System.out.println();
    }


}
