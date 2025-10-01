package com.example;

public class SniperTank extends Tank{

    public SniperTank() {
        super("Shadow", 1, TankClass.LIGHT, PilotType.HUMAN, 40);
           
    }

    @Override
    protected void InitializeTankSettings() {
        throw new UnsupportedOperationException("Unimplemented method 'InitializeTankSettings'");
    }

    @Override
    protected Module CreateModule() {
        return new Sniper();
    }

    @Override
    protected int getRepairTurnsDuration() {
        return 3; 
    }
    
}

