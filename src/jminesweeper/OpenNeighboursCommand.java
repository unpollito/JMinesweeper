package jminesweeper;

public class OpenNeighboursCommand {

    private static GameController controller;

    public void execute(Cell cell) {
        try {
            cell.openNeighbours();
        } catch (MineExplodedException e) {
            controller.mineExploded();
            return;
        } catch (WonGameException e) {
            controller.wonGame();
            return;
        }
    }

    public static void setController(GameController controller) {
        OpenNeighboursCommand.controller = controller;
    }
}
