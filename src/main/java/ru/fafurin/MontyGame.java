package ru.fafurin;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class MontyGame {
    Random random = new Random();
    private final HashMap<Integer, String> field = new HashMap<>(3);
    int playerDoorIndex;
    int selectionChangingIndex;
    int montyDoorIndex;

    public MontyGame() {
        initField();
        setDoors();
        getResults();
    }

    public void setDoors() {
        playerDoorIndex = random.nextInt(1, 4);
        for (int i = 1; i <= 3; i++) {
            if (field.get(i).equals("sheep") && i != playerDoorIndex) montyDoorIndex = i;
        }
        field.remove(montyDoorIndex);
    }

    public void getResults() {
        Set<Integer> keys = field.keySet();
        for (Integer key : keys) {
            if (key != playerDoorIndex && key != montyDoorIndex)
                selectionChangingIndex = key;
        }
    }

    public boolean getResultWithSelectionChanging() {
        return field.get(selectionChangingIndex).equals("car");
    }

    public boolean getResultWithoutSelectionChanging() {
        return field.get(playerDoorIndex).equals("car");
    }

    public void initField() {
        int carDoorIndex = random.nextInt(1, 4);
        field.put(1, "sheep");
        field.put(2, "sheep");
        field.put(3, "sheep");
        field.put(carDoorIndex, "car");
    }
}
