package ru.karian.Jungle.model;

public class Lion {
    private int hp = 100;
    private int energy = 100;
    private final double FANGS = 2.5;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public double getFangs() {
        return FANGS;
    }

}
