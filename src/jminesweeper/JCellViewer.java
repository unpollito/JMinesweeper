package jminesweeper;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class JCellViewer extends JPanel implements CellViewer, MouseListener {

    private static final String NORMAL_CELL = "images/nomine.png";
    private static final String FLAGGED_CELL = "images/flagged.png";
    private static final String DUBIOUS_CELL = "images/dubious.png";
    private static final String HIGHLIGHTED_CELL = "images/highlighted.png";
    private static final String HIGHLIGHTED_FLAGGED_CELL = "images/highlightedflagged.png";
    private static final String HIGHLIGHTED_DUBIOUS_CELL = "images/highlighteddubious.png";
    private static final String MINE_CELL = "images/mine.png";
    Cell cell;
    BufferedImage picture;

    public JCellViewer(Cell observedCell) {
        addMouseListener(this);
        this.cell = observedCell;

        cell.setCTVListener(new CellToViewerListener() {

            @Override
            public void cellChanged() {
                refresh();
            }
        });
        this.setSize(new Dimension(20, 20));
        picture = FileImageLoader.loadImage(NORMAL_CELL);
    }

    private void refresh() {
        if (cell.getIsOpen()) {
            if (cell.getHasMine()) {
                picture = FileImageLoader.loadImage(MINE_CELL);
            } else {
                String path = "images/" + cell.getNeighbourMineCount() + ".gif";
                picture = FileImageLoader.loadImage(path);
            }
        } else {
            if (cell.getFlag() == Cell.NO_FLAG) {
                picture = FileImageLoader.loadImage(NORMAL_CELL);
            } else if (cell.getFlag() == Cell.FLAG) {
                picture = FileImageLoader.loadImage(FLAGGED_CELL);
            } else if (cell.getFlag() == Cell.DOUBT_FLAG) {
                picture = FileImageLoader.loadImage(DUBIOUS_CELL);
            }
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(picture, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            OpenCellCommand openCommand = new OpenCellCommand();
            openCommand.execute(cell);
        }
        if (e.getButton() == MouseEvent.BUTTON2) {
            OpenNeighboursCommand openCommand = new OpenNeighboursCommand();
            openCommand.execute(cell);
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            SwitchFlagCommand flagCommand = new SwitchFlagCommand();
            flagCommand.execute(cell);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (!cell.getIsOpen()) {
            if (cell.getFlag() == Cell.NO_FLAG) {
                picture = FileImageLoader.loadImage(HIGHLIGHTED_CELL);
            }
            if (cell.getFlag() == Cell.FLAG) {
                picture = FileImageLoader.loadImage(HIGHLIGHTED_FLAGGED_CELL);
            }
            if (cell.getFlag() == Cell.DOUBT_FLAG) {
                picture = FileImageLoader.loadImage(HIGHLIGHTED_DUBIOUS_CELL);
            }
        }
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        refresh();
    }
}