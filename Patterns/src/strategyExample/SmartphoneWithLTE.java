package strategyExample;

public class SmartphoneWithLTE extends Smartphone{
    public SmartphoneWithLTE() {
        setCommunication(new LTE());
    }
}
