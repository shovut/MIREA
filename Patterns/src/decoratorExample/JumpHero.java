package decoratorExample;

public class JumpHero extends Hero{
    public JumpHero() {
        name = "Jump Hero";
    }

    public int getLevel(){
        return 1;
    }
}
