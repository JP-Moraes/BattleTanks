package com.example;

public class FortressTank extends Tank {

    public FortressTank() {
        super("Titan", 2, TankClass.HEAVY, PilotType.AI, 700);
        
    }

    @Override
    protected void InitializeTankSettings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'InitializeTankSettings'");
    }

    @Override
    protected Module CreateModule() {
        return new Cannon();

    }

    @Override
    protected int getRepairTurnsDuration() {
        return 5;
    }
    
}

