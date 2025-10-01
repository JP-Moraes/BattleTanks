package com.example.TanksAndWeapons;

import com.example.Module;
import com.example.Tank;
import com.example.ENUMS.PilotType;
import com.example.ENUMS.TankClass;

public class BlastTank extends Tank {

    public BlastTank() {
        super("Crimson", 3, TankClass.MEDIUM, PilotType.AI, 200);
        
    }

    @Override
    protected void InitializeTankSettings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'InitializeTankSettings'");
    }

    @Override
    protected Module CreateModule() {
        return new RocketLauncher();
    }

    @Override
    protected int getRepairTurnsDuration() {
        return 4;
    }
    
}
