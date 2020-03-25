package ru.mirea.strategyExample;

public abstract class Smartphone {
    private Communication communication;

    public void setCommunication(Communication communication) {
        this.communication = communication;
    }

    public void communicationTest(){
        communication.communicate();
    }
}

interface Communication {
    public void communicate();
}

class LTE implements Communication {
    @Override
    public void communicate() {
        System.out.println("LTE");
    }
}

class WIFI implements Communication {
    @Override
    public void communicate() {
        System.out.println("WIFI");
    }
}

