package decoratorExample;

public class Armor extends Decorator{
    Hero hero;

    public Armor(Hero hero) {
        this.hero = hero;
    }

    @Override
    public String getInfo() {
        return hero.getInfo() + " have armor";
    }

    @Override
    public int getLevel() {
        return hero.getLevel() + 4;
    }
}
