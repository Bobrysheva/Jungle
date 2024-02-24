package ru.karian.Jungle._main;

import ru.karian.Jungle.model.Lion;
import ru.karian.Jungle.util.EventProduser;

public class Main {
    public static void main(String[] args) {
        Lion lion = new Lion();
        EventProduser ep1 = new EventProduser();
        ep1.startSimulatin(lion);
    }
}