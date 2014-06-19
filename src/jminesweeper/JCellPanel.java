package jminesweeper;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class JCellPanel extends JPanel implements CellPanel {

    JCellViewer[][] cellViewers;

    public JCellPanel(Cell[][] cells, int vSize, int hSize) {
        this.setLayout(new GridLayout(cells.length, cells[0].length, 0, 0));
        this.setMinimumSize(new Dimension(vSize, hSize));

        // Create all the cells.
        cellViewers = new JCellViewer[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cellViewers[i][j] = new JCellViewer(cells[i][j]);
                this.add(cellViewers[i][j]);
            }
        }
    }
}