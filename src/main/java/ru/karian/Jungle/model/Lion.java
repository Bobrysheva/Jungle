package ru.karian.Jungle.model;

public class Lion {
    private int hp = 100; // = 100
    private int energy = 100; //  = 100
    private final double FANGS = 2.5; // *hp

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

    public static void checkEnergy(Lion lion) {
        int energy = lion.getEnergy();
        int health = lion.getHp();
        if (energy < 0) {
            energy = 0;
            health = health - 5;
            System.out.println("Энергия льва окончательно истощилась! Текущая энергия: " + energy);
        } else if (energy > 100) {
            energy = 100;
            System.out.println("Лев полон сил и энергии! Текущая энергия: " + energy);
        }
        lion.setEnergy(energy);
        lion.setHp(health);
    }

    public static void checkHp(Lion lion) {
        int health = lion.getHp();
        if (health < 0) {
            health = 0;
        } else if (health > 100) {
            health = 100;
            System.out.println("Лев абсолютно здоров! Показатель здоровья: " + health);
        } else System.out.println("Текущее здоровье: " + health);
        lion.setHp(health);
    }

}
