package jminesweeper;

public interface PreferencesDialogShower {

    public static final String BEGINNER = "Beginner: 9x9 tiles, 10 mines";
    public static final String INTERMEDIATE = "Intermediate: 16x16 tiles, 40 mines";
    public static final String EXPERT = "Expert: 16x30 tiles, 99 mines";

    public String getDifficultyLevel();
}
