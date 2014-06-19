package jminesweeper;

public interface MessageAnnounce {

    public final int MESSAGE = 55;
    public final int ERROR = 56;

    public void announce(String text, int type);
}
