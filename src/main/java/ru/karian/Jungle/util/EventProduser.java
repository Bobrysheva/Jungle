package ru.karian.Jungle.util;

import ru.karian.Jungle.model.Lion;

public class EventProduser {
    // поспал + 7
    // ничего не нашел после пробежки -7
    // съел газель - 7 еnergy и коэф.зубов*10 здоровья;
    // съел слона  - 15 energy и  коэф.зубов*20 здоровья;
    // на льва напал охотник - 40 энергии и - 10 здоровья;
    // если энергии 0 , то  - 5 здоровья
    public void startSimulatin(Lion lion) {
        while (checkStatus(lion)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 40) {
                sleepEvent(lion);
            } else if (eventNumber >= 40 && eventNumber < 60) {
                justMove(lion);
            } else if (eventNumber >= 80 && eventNumber < 100) {
                meetHunter(lion);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Лев скончался!!! Game over :(");

    }

    private void sleepEvent(Lion lion) {
        System.out.println("Лев хорошенько выспался");
        int energy = lion.getEnergy() + 7;
        int health = lion.getHp();
        lion.setEnergy(energy);
        lion.setHp(health);
        Lion.checkEnergy(lion);
    }

    private void justMove(Lion lion) {
        System.out.println("Лев пробегал весь день и остался с носом.");
        int energy = lion.getEnergy() - 7;
        lion.setEnergy(energy);
        int health = lion.getHp();
        lion.setEnergy(energy);
        lion.setHp(health);
        Lion.checkEnergy(lion);
    }

    private void lionEatGazelle(Lion lion) {
        System.out.println("Лев поймал газель и съел её!");
        int energy = lion.getEnergy() - 7;
        int health = lion.getHp();
        health = health + (int) (10 * lion.getFangs());
        lion.setEnergy(energy);
        lion.setHp(health);
        Lion.checkEnergy(lion);
        checkHp(lion);
    }

    private void lionEatElephant(Lion lion) {
        System.out.println("Лев поймал слона и съел его!");
        int energy = lion.getEnergy() - 15;
        int health = lion.getHp();
        health = health + (int) (20 * lion.getFangs());
        lion.setEnergy(energy);
        lion.setHp(health);
        Lion.checkEnergy(lion);
        checkHp(lion);
    }

    private void meetHunter(Lion lion) {
        System.out.println("Лев бегает от охотника!!!");
        int energy = lion.getEnergy() - 40;
        int health = lion.getHp();
        health = health - 10;
        lion.setEnergy(energy);
        lion.setHp(health);
        Lion.checkEnergy(lion);
        checkHp(lion);
    }

//    public void checkEnergy(Lion lion) {
//        int energy = lion.getEnergy();
//        int health = lion.getHp();
//        if (energy < 0) {
//            energy = 0;
//            health = health - 5;
//            System.out.println("Энергия льва окончательно истощилась! Текущая энергия: " + energy);
//        } else if (energy > 100) {
//            energy = 100;
//            System.out.println("Лев полон сил и энергии! Текущая энергия: " + energy);
//        }
//        lion.setEnergy(energy);
//        lion.setHp(health);
//    }



    private boolean checkStatus(Lion lion) {
        System.out.println("Проверка статуса. У царя зверей " + lion.getHp() + " здоровья и " + lion.getEnergy() + " энергии");
        if (lion.getHp() <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
