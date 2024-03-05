package ru.karian.Jungle._main;

import ru.karian.Jungle.model.Lion;
import ru.karian.Jungle.util.EventProducer;

public class Main {
    public static void main(String[] args) {
        Lion lion = new Lion();
        EventProducer ep = new EventProducer();
        ep.startSimulatin(lion);
    }
}