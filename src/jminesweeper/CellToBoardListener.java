package jminesweeper;

public interface CellToBoardListener {

    public void cellChanged() throws WonGameException;
}
