package decoratorExample;

public class StrongHero extends Hero{
    public StrongHero() {
        name = "Strong Hero";
    }

    public int getLevel(){
        return 2;
    }
}
