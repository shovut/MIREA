package ru.mirea.facadeExample;


public class ComputerSystemInterface {
    private EnergyPower energyPower;
    private Monitor monitor;
    private SystemUnit systemUnit;

    public ComputerSystemInterface(EnergyPower energyPower, Monitor monitor, SystemUnit systemUnit) {
        this.energyPower = energyPower;
        this.monitor = monitor;
        this.systemUnit = systemUnit;
    }

    public void start(){
        energyPower.powerOn();
        monitor.monitorActivate();
        systemUnit.loadOS();
    }

    public void off(){
        monitor.monitorDeactivate();
        energyPower.powerOff();
    }
}
