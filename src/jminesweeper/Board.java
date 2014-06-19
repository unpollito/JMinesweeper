package jminesweeper;

import java.util.Timer;
import java.util.TimerTask;

public class Board {

    private Cell[][] cells;
    private int hSize;
    private int vSize;
    private int time;
    private int unopenedCells;
    private int amountOfMines;
    private Timer timer;
    private TimerTask task;

    public Board(GamePreferences preferences) {
        this.vSize = preferences.getvSize();
        this.hSize = preferences.gethSize();
        this.amountOfMines = preferences.getAmountOfMines();
        unopenedCells = hSize * vSize;

        cells = new Cell[vSize][hSize];
        for (int i = 0; i < vSize; i++) {
            for (int j = 0; j < hSize; j++) {
                cells[i][j] = new Cell();
            }
        }

        MineGenerator.generate(cells, amountOfMines);

        for (int i = 0; i < vSize; i++) {
            for (int j = 0; j < hSize; j++) {
                // Add a listener to each cell
                cells[i][j].setCTBListener(new CellToBoardListener() {

                    @Override
                    public void cellChanged() throws WonGameException {
                        unopenedCells--;
                        if (unopenedCells == amountOfMines) {
                            throw new WonGameException();
                        }
                    }
                });

                // Add neighbours to each cell. Make sure we don't use
                // out-of-range indexes.
                if (i > 0) {
                    cells[i][j].addNeighbour(cells[i - 1][j]);
                    if (j > 0) {
                        cells[i][j].addNeighbour(cells[i - 1][j - 1]);
                    }
                    if (j < hSize - 1) {
                        cells[i][j].addNeighbour(cells[i - 1][j + 1]);
                    }
                }
                if (i < vSize - 1) {
                    cells[i][j].addNeighbour(cells[i + 1][j]);
                    if (j > 0) {
                        cells[i][j].addNeighbour(cells[i + 1][j - 1]);
                    }
                    if (j < hSize - 1) {
                        cells[i][j].addNeighbour(cells[i + 1][j + 1]);
                    }
                }
                if (j > 0) {
                    cells[i][j].addNeighbour(cells[i][j - 1]);
                }
                if (j < hSize - 1) {
                    cells[i][j].addNeighbour(cells[i][j + 1]);
                }
            }
        }
        
        task = new TimerTask() {

            @Override
            public void run() {
                time++;
                System.out.println(time);
            }
            
        };
        
        // Set the timer
        timer = new Timer ();
        timer.scheduleAtFixedRate(task, 0l, 1000l);

    }

    public int getAmountOfMines() {
        return amountOfMines;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getHSize() {
        return hSize;
    }

    public int getUnopenedCells() {
        return unopenedCells;
    }

    public int getVSize() {
        return vSize;
    }

    public int getTime() {
        return time;
    }

    public void cellOpened() {
        unopenedCells--;
    }

    public void forceOpen() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j].forceOpen();
            }
        }
        stopTimer();
    }
    
    public void stopTimer() {
        timer.cancel();
    }
}
