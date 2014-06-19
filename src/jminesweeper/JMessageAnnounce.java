package jminesweeper;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JMessageAnnounce implements MessageAnnounce {

    @Override
    public void announce(String text, int type) {
        if (type == MESSAGE) {
            JOptionPane.showMessageDialog(new JFrame(), text, "Game over!", JOptionPane.INFORMATION_MESSAGE);
        } else if (type == ERROR) {
            JOptionPane.showMessageDialog(new JFrame(), text, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
