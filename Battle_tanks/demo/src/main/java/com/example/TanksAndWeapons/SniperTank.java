package com.example.TanksAndWeapons;

import com.example.Module;
import com.example.Tank;
import com.example.ENUMS.PilotType;
import com.example.ENUMS.TankClass;

public class SniperTank extends Tank{

    public SniperTank() {
        super("");
        
    }

    @Override
    protected void InitializeTankSettings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'InitializeTankSettings'");
    }

    @Override
    protected Module CreateModule() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CreateModule'");
    }

    @Override
    protected int getRepairTurnsDuration() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRepairTurnsDuration'");
    }
    
}
