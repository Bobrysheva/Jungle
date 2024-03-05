package ru.karian.Jungle.util;
import ru.karian.Jungle.model.Lion;

public class CheckService {
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

    public static boolean checkStatus(Lion lion) {
        System.out.println("Проверка статуса. У царя зверей " + lion.getHp() + " здоровья и " + lion.getEnergy() + " энергии");
        while (lion.getHp() > 0) {
            return true;
        }
        return false;
    }
}
