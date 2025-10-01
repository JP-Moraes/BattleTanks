package com.example.TanksAndWeapons;

import com.example.Module;
import com.example.Tank;
import com.example.ENUMS.PilotType;
import com.example.ENUMS.TankClass;

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
