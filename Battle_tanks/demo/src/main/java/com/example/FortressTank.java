package com.example.TanksAndWeapons;

import com.example.Module;
import com.example.Tank;
import com.example.ENUMS.PilotType;
import com.example.ENUMS.TankClass;

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
