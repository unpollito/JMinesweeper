package jminesweeper;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;

public class JRestartGameCommand extends AbstractAction implements RestartGameCommand {

    private static GameController controller;

    public JRestartGameCommand(String name, Icon icon) {
        super(name, icon);
    }

    public static void setController(GameController controller) {
        JRestartGameCommand.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        restart();
    }

    @Override
    public void restart() {
        controller.startGame();
    }
}
