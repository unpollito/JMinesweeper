package jminesweeper;

public class GameController {

    private Board board;
    private MainFrame mainFrame;
    private GamePreferences preferences;
    private MessageAnnounce announcer;
    private boolean closing = false;

    public GameController(GamePreferences preferences, MessageAnnounce announcer) {
        this.preferences = preferences;
        this.announcer = announcer;
    }

    public void startGame() {
        board = new Board(preferences);
        if (mainFrame == null) {
            mainFrame = new JMainFrame(board);
        }
        mainFrame.setBoard(board);
        mainFrame.drawBoard();
    }

    public void couldNotOpenFile() {
        if (!closing) {
            closing = true;
            announcer.announce("A vital file is missing.\nJMinesweeper must close.", MessageAnnounce.ERROR);
            mainFrame.dispose();
            board.stopTimer();
        }
    }

    public void mineExploded() {
        announcer.announce("Tough luck, you've stepped onto a mine!", MessageAnnounce.MESSAGE);
        board.forceOpen();
    }

    public void wonGame() {
        closing = true;
        String message = "Congratulations, you've won in " + board.getTime() + " seconds!";
        announcer.announce(message, MessageAnnounce.MESSAGE);
        board.forceOpen();
    }
}
