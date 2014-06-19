package jminesweeper;

import javax.swing.JOptionPane;

public class JPreferencesDialogShower {

    public String getDifficultyLevel() {
        try {
            String[] values = {PreferencesDialogShower.BEGINNER,
                PreferencesDialogShower.INTERMEDIATE,
                PreferencesDialogShower.EXPERT};
            return JOptionPane.showInputDialog(null,
                    "Welcome! Please select a difficulty level.",
                    "Minesweeper",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    values,
                    values[0]).toString();
        } // Just in case the user closes the difficulty window.
        catch (NullPointerException e) {
            return "";
        }
    }
}
