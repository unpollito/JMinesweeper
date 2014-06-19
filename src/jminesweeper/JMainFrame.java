package jminesweeper;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class JMainFrame extends JFrame implements MainFrame {

    Board board;
    JCellPanel cellPanel;

    public JMainFrame(Board board) {
        this.board = board;
        setTitle("Minesweeper");
        setSize((board.getHSize() * 20), (board.getVSize() * 20) + 30);
        setResizable(false);
        setLocationRelativeTo(null); // Centers window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.add(new JRestartButton());
        setVisible(true);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void drawBoard() {
        setVisible(false);
        if (cellPanel != null) {
            this.remove(cellPanel);
        }
        this.cellPanel = new JCellPanel(board.getCells(),
                board.getVSize() * 20,
                board.getHSize() * 20);
        this.add(cellPanel);
        setVisible(true);
    }
}
