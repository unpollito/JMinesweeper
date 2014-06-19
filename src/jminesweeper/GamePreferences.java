package jminesweeper;

public class GamePreferences {

    private int vSize, hSize, amountOfMines;

    public GamePreferences(int vSize, int hSize, int amountOfMines) {
        this.vSize = vSize;
        this.hSize = hSize;
        this.amountOfMines = amountOfMines;
    }

    public int getAmountOfMines() {
        return amountOfMines;
    }

    public int gethSize() {
        return hSize;
    }

    public int getvSize() {
        return vSize;
    }
}
