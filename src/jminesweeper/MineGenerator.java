package jminesweeper;

import java.util.Random;

/**
 *
 * @author David
 */
public class MineGenerator {

    public static void generate(Cell[][] cells, int amountOfMines) {
        /* Generate random numbers so as to choose where to place the mines.
         * We use System.currentTimeMillis() as the seed for our random
         * number generator.
         */
        Random generator = new Random(System.currentTimeMillis());
        int index;
        int vSize = cells.length;
        int hSize = cells[0].length;
        for (int i = 0; i < amountOfMines; i++) {
            index = generator.nextInt(hSize * vSize);
            /* If we've chosen to put a mine inside a cell which already
             * has a mine, we'll put it in the next cell instead.
             */
            while (cells[index / hSize][index % hSize].getHasMine()) {
                index++;
                if (index == vSize * hSize) {
                    index = 0;
                }
            }
            cells[index / hSize][index % hSize].setHasMine(true);
        }
    }
}
