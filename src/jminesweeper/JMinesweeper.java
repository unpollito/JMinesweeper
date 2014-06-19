package jminesweeper;

public class JMinesweeper {

    public static void main(String[] args) {
        GamePreferences preferences = new JPreferencesChooser().getPreferences();
        GameController controller = new GameController(preferences, new JMessageAnnounce());
        OpenCellCommand.setController(controller);
        OpenNeighboursCommand.setController(controller);
        JRestartGameCommand.setController(controller);
        FileImageLoader.setController(controller);
        controller.startGame();
    }
}
