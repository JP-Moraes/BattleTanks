package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.ENUMS.TankClass;
import com.example.ENUMS.PilotType;

public class TankRegistry {

    //atributos da classe
    private List<Tank> registeredTanks;
    private int nextTankID;
    private int maxTanks;

    public TankRegistry(){
        this(12);
    }

    public TankRegistry(int maxTanks) {
        this.registeredTanks = new ArrayList<>();
        this.nextTankID = 1;
        this.maxTanks = maxTanks;
    }

    // = = = = METODOS DO REGISTRO = = = = = =

    public boolean registerTank(Tank tank) {
        if (tank ==  null) {
            System.out.println("❌ Cannot register null tank!");
            return false;
        }
        
        // Verifica o limite de tanks maximo

        if (isRegistryFull()) {
            System.out.println("❌ Tank registry is full! Maximum " + maxTanks + " tanks allowed.");
            return false;
        }

        //Checa se o codinome do tanques são iguais
        if(isCodenameTaken(tank.getCodename())) {
            System.out.println("❌ Codename '" + tank.getCodename() + "' is already taken!");
            return false;
        }

        //Gera um ID automatico
        if (tank.getId() == 0) {
            tank.setId(nextTankID);
            nextTankID++;
        }

        registeredTanks.add(tank);
        System.out.println("✅ Tank '" + tank.getCodename() + "' registered successfully! ID: " + tank.getId());
        return true;
    }

    // = = = = = Metodo de Busca = = = = = //

        public Tank findTankByCodename(String codename) {
        return registeredTanks.stream()
                .filter(tank -> tank.getCodename().equalsIgnoreCase(codename))
                .findFirst()
                .orElse(null);
    }

        public Tank findTankById(int id) {
        return registeredTanks.stream()
                .filter(tank -> tank.getId() == id)
                .findFirst()
                .orElse(null);
   }
        public List<Tank> findTanksByClass(TankClass tankClass) {
        return registeredTanks.stream()
                .filter(tank -> tank.getClassType() == tankClass)
                .collect(Collectors.toList());
    }

        public List<Tank> findTanksByPilotType(PilotType pilotType) {
        return registeredTanks.stream()
                .filter(tank -> tank.getPilotType() == pilotType)
                .collect(Collectors.toList());
    }

    // = = = = = METODOS DE RELATIOS = = = = = = //

    
    public void displayAllTanks() {
        if (registeredTanks.isEmpty()) {
            System.out.println("📭 No tanks registered!");
            return;
        }

        System.out.println("\n=== 🎯 REGISTERED TANKS (" + registeredTanks.size() + ") ===");
        for (Tank tank : registeredTanks) {
            displayTankInfo(tank);
            System.out.println("────────────────────────────");
        }
    }

    public void displayTanksByClass(TankClass tankClass) {
        List<Tank> tanks = findTanksByClass(tankClass);
        if (tanks.isEmpty()) {
            System.out.println("📭 No " + tankClass + " tanks registered!");
            return;
        }

        System.out.println("\n=== " + tankClass + " TANKS (" + tanks.size() + ") ===");
        for (Tank tank : tanks) {
            displayTankInfo(tank);
            System.out.println("────────────────────────────");
        }
    }


    public void displayTankInfo(Tank tank) {
        if (tank == null) {
            System.out.println("❌ Tank is null!");
            return;
        }

        System.out.println("🔸 Codename: " + tank.getCodename());
        System.out.println("   ID: " + tank.getId());
        System.out.println("   Class: " + tank.getClassType());
        System.out.println("   Pilot: " + tank.getPilotType());
        
        if (tank.getWeapon() != null) {
            System.out.println("   Weapon: " + tank.getWeapon().getClass().getSimpleName());
            System.out.println("   Ammo: " + tank.getWeapon().getCurrentAmmo() + "/" + tank.getWeapon().getMaxAmmo());
        } else {
            System.out.println("Weapon: No weapon assigned");
        }
    }




    // = = = METODOS ULTILITARIOS = = = = = 

    // Verifica se um codename já está em uso

    private boolean isCodenameTaken(String codename) {
        return registeredTanks.stream()
                .anyMatch(tank -> tank.getCodename().equalsIgnoreCase(codename));
    }

    //Retorna todos os tanques ativos (não destruídos)

    public List<Tank> getActiveTanks() {
        return registeredTanks.stream()
                .filter(Tank::IsAlive)
                .collect(Collectors.toList());
    }

    //Retorna todos os tanques registrados
     
    public List<Tank> getAllTanks() {
        return new ArrayList<>(registeredTanks);
    }

    // Retorna o número total de tanques registrados

    public int getTotalTanks() {
        return registeredTanks.size();
    }

    //  Retorna o número de tanques ativos

    public int getActiveTanksCount() {
        return getActiveTanks().size();
    }

    //Limpa todo o registro (para resetar o jogo)

    public void clearRegistry() {
        registeredTanks.clear();
        nextTankID = 1;
        System.out.println("🧹 Tank registry cleared!");
    }

    // Verifica se existem tanques suficientes para um modo de jogo
     
    public boolean hasEnoughTanksForGame(int requiredTanks) {
        int activeCount = getActiveTanksCount();
        boolean hasEnough = activeCount >= requiredTanks;
        
        if (!hasEnough) {
            System.out.println("❌ Not enough active tanks! Need " + requiredTanks + ", but only have " + activeCount);
        }
        
        return hasEnough;
    }


    // Metodos de limitação de quantidade de tanque

    // Verifica se o registro atingiu o limite máximo
    public boolean isRegistryFull() {
        return registeredTanks.size() >= maxTanks;
    }

    //Verifica quantos tanques ainda podem ser registrados

    public int getRemainingSlots() {
        return Math.max(0, maxTanks - registeredTanks.size());
    }

    //Retorna o limite máximo de tanques
    public int getMaxTanks() {
        return maxTanks;
    }

     public void setMaxTanks(int maxTanks) {
        this.maxTanks = maxTanks;
        System.out.println("🎯 Maximum tanks limit set to: " + maxTanks);
        
        // Se necessário, remove tanques excedentes
        if (registeredTanks.size() > maxTanks) {
            int excess = registeredTanks.size() - maxTanks;
            for (int i = 0; i < excess; i++) {
                registeredTanks.remove(registeredTanks.size() - 1);
            }
            System.out.println("🗑️ Removed " + excess + " excess tanks to fit new limit.");
        }
    }

}
