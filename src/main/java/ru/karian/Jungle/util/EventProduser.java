package ru.karian.Jungle.util;

import ru.karian.Jungle.model.Lion;

public class EventProduser {
    public void startSimulatin(Lion lion) {
        while (checkStatus(lion)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 10) {
                sleepEvent(lion);
            } else if (eventNumber >= 10 && eventNumber < 20) {
                drinkEvent(lion);
            } else if (eventNumber >= 20 && eventNumber < 35) {
                conflictEvent(lion);
            } else if (eventNumber >= 35 && eventNumber < 40) {
                playEvent(lion);
            } else if (eventNumber >= 40 && eventNumber < 45) {
                eatHyenaEvent(lion);
            } else if (eventNumber >= 45 && eventNumber < 50) {
                rainingEvent(lion);
            } else if (eventNumber >= 50 && eventNumber < 70) {
                justMove(lion);
            } else if (eventNumber >= 70 && eventNumber < 80) {
                lionEatGazelle(lion);
            } else if (eventNumber >= 80 && eventNumber < 85) {
                lionEatElephant(lion);
            } else if (eventNumber >= 85 && eventNumber < 100) {
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

    private void drinkEvent(Lion lion) {
        System.out.println("Лев вдоволь напился!");
        int energy = lion.getEnergy() + 5;
        int health = lion.getHp();
        health = health + 2;
        lion.setEnergy(energy);
        lion.setHp(health);
        Lion.checkEnergy(lion);
        Lion.checkHp(lion);
    }

    private void conflictEvent(Lion lion) {
        System.out.println("Лев защищал территорию");
        int energy = lion.getEnergy() - 80;
        int health = lion.getHp();
        health = health - 20;
        lion.setEnergy(energy);
        lion.setHp(health);
        Lion.checkEnergy(lion);
        Lion.checkHp(lion);
    }

    private void playEvent(Lion lion) {
        System.out.println("Лев поиграл и в отличном настроении!");
        int energy = lion.getEnergy() + 5;
        lion.setEnergy(energy);
        Lion.checkEnergy(lion);
    }

    private void eatHyenaEvent(Lion lion) {
        System.out.println("Лев поймал гиену и съел её!");
        int energy = lion.getEnergy() - 10;
        int health = lion.getHp();
        health = health + (int) (12 * lion.getFangs());
        lion.setEnergy(energy);
        lion.setHp(health);
        Lion.checkEnergy(lion);
        Lion.checkHp(lion);
    }

    private void rainingEvent(Lion lion) {
        System.out.println("Лев бегал под дождем");
        int energy = lion.getEnergy() - 5;
        int health = lion.getHp();
        health = health - 5;
        lion.setEnergy(energy);
        lion.setHp(health);
        Lion.checkEnergy(lion);
        Lion.checkHp(lion);
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
        Lion.checkHp(lion);
    }

    private void lionEatElephant(Lion lion) {
        System.out.println("Лев поймал слона и съел его!");
        int energy = lion.getEnergy() - 15;
        int health = lion.getHp();
        health = health + (int) (20 * lion.getFangs());
        lion.setEnergy(energy);
        lion.setHp(health);
        Lion.checkEnergy(lion);
        Lion.checkHp(lion);
    }

    private void meetHunter(Lion lion) {
        System.out.println("Лев бегает от охотника!!!");
        int energy = lion.getEnergy() - 40;
        int health = lion.getHp();
        health = health - 20;
        lion.setEnergy(energy);
        lion.setHp(health);
        Lion.checkEnergy(lion);
        Lion.checkHp(lion);
    }

    public void checkEnergy(Lion lion) {
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

    private boolean checkStatus(Lion lion) {
        System.out.println("Проверка статуса. У царя зверей " + lion.getHp() + " здоровья и " + lion.getEnergy() + " энергии");
        if (lion.getHp() <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
