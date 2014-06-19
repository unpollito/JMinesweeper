package jminesweeper;

public class OpenCellCommand {

    private static GameController controller;

    public void execute(Cell cell) {
        try {
            cell.open();
        } catch (MineExplodedException e) {
            controller.mineExploded();
            return;
        } catch (WonGameException e) {
            controller.wonGame();
            return;
        }
    }

    public static void setController(GameController controller) {
        OpenCellCommand.controller = controller;
    }
}
