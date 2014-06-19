package jminesweeper;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class JRestartButton extends JButton implements RestartButton {

    public JRestartButton() {
        this.setPreferredSize(new Dimension(20, 20));
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setAction(new JRestartGameCommand("", new ImageIcon("images/smiley.gif")));
    }
}
