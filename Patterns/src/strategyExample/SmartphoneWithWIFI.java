package strategyExample;

public class SmartphoneWithWIFI extends Smartphone{
    public SmartphoneWithWIFI() {
        setCommunication(new WIFI());
    }
}
