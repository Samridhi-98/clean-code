package com.d.tdd;

public class GameSolution {
    int[] rolls = new int[21];
    int rollIndex = 0;

    public void roll(int pinsKnockedDown) {
        rolls[rollIndex++] = pinsKnockedDown;
    }

    public int score() {
        int totalPoints = 0;
        int rollsIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if(isStrike(rollsIndex)) {
                totalPoints += 10 + bonusForStrike(rollsIndex);
                rollsIndex += 1;
            }
            else if (isSpare(rollsIndex)) {
                totalPoints += 10 + bonusForSpare(rollsIndex);
                rollsIndex += 2;
            } else {
                totalPoints += rolls[rollsIndex] + rolls[rollsIndex + 1];
                rollsIndex += 2;
            }

        }

        return totalPoints;
    }

    private int bonusForSpare(int rollsIndex) {
        return rolls[rollsIndex + 2];
    }

    private int bonusForStrike(int rollsIndex) {
        return rolls[rollsIndex + 1] + bonusForSpare(rollsIndex);
    }

    private boolean isStrike(int rollsIndex) {
        return rolls[rollsIndex] == 10;
    }

    private boolean isSpare(int rollsIndex) {
        return rolls[rollsIndex] + rolls[rollsIndex + 1] == 10;
    }
}
