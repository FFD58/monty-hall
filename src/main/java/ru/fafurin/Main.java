package ru.fafurin;

import org.apache.commons.math3.stat.Frequency;

public class Main {
    public static void main(String[] args) {
        Frequency frequencyWithSelectionChanging = new Frequency();
        Frequency frequencyWithoutSelectionChanging = new Frequency();

        MontyGame montyGame;
        for (int i = 0; i < 1000; i++) {
            montyGame = new MontyGame();
            frequencyWithSelectionChanging.addValue(montyGame.getResultWithSelectionChanging());
            frequencyWithoutSelectionChanging.addValue(montyGame.getResultWithoutSelectionChanging());
        }

        System.out.println("Frequency with player selection changing\n" + frequencyWithSelectionChanging);
        System.out.println("Frequency without player selection changing\n" + frequencyWithoutSelectionChanging);
    }
}