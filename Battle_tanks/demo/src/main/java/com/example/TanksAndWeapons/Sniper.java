package com.example.TanksAndWeapons;

import com.example.Module;
import com.example.ENUMS.AmmoType;

public class Sniper extends Module {

    protected Sniper() {
        super(AmmoType.PIERCING, 100.0, 10);
    }

    private boolean isPerfectAim() {
        return Math.random() < 0.3; //Chance critica de 30% da sniper
    }

    @Override 
    public double CalculateDamage() {

        //Logica exclusiva da Sniper

        if(!CanShot()) return 0;

        boolean criticalHIt = isPerfectAim();
        double aimMultiplier = criticalHIt ? 2.0 : 1.0;

        double baseDamage = super.getBaseDMG() * super.getAmmoType().getAmmoBonus();
        double finalDamage = baseDamage * aimMultiplier;

        currentAmmo -= getAmmoConsumption();
        currentHeat -= getHeatPerShot();

        return finalDamage; 

    }

    @Override
    public int getAmmoConsumption() {
        return 1; //Consone 1 bala; 
    }

    @Override
    public double getMaxHeat() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getMaxHeat'");
    }

    @Override
    public double getHeatPerShot() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getHeatPerShot'");
    }

    @Override
    public double getHeatDissipationRate() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getHeatDissipationRate'");
    }

    @Override
    public double getOverheatThreshold() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getOverheatThreshold'");
    }

    @Override
    public int getCoolingEffiency() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getCoolingEffiency'");
    }

    @Override
    public int getAmmoPerReload() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getAmmoPerReload'");
    }

    @Override
    public int BaseReloadTurns() {
        
        throw new UnsupportedOperationException("Unimplemented method 'BaseReloadTurns'");
    }

    @Override
    public int getAccuracyBack() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getAccuracyBack'");
    }

    @Override
    public int getAccuracyFrontal() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getAccuracyFrontal'");
    }

    @Override
    public int getAccuracyLateral() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getAccuracyLateral'");
    }
    
}
