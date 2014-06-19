package jminesweeper;

class JPreferencesChooser implements PreferencesChooser {

    public GamePreferences getPreferences() {
        String choice = new JPreferencesDialogShower().getDifficultyLevel();
        if (choice.equals(PreferencesDialogShower.BEGINNER)) {
            return new GamePreferences(9, 9, 10);
        }
        if (choice.equals(PreferencesDialogShower.INTERMEDIATE)) {
            return new GamePreferences(16, 16, 40);
        }
        if (choice.equals(PreferencesDialogShower.EXPERT)) {
            return new GamePreferences(16, 30, 99);
        }
        return new GamePreferences(9, 9, 10);
    }
}
