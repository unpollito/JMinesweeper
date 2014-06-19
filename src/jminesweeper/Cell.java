package jminesweeper;

class Cell {

    final static public int NO_FLAG = 30;
    final static public int FLAG = 31;
    final static public int DOUBT_FLAG = 32;
    private boolean hasMine;
    private boolean isOpen;
    private int flag;
    private CellList neighbourList;
    private CellToBoardListener cellToBoardListener;
    private CellToViewerListener cellToViewerListener;

    public Cell() {
        hasMine = false;
        isOpen = false;
        flag = NO_FLAG;
        neighbourList = new CellList();
    }

    public void addNeighbour(Cell neighbour) {
        neighbourList.add(neighbour);
    }

    public void setHasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public boolean getHasMine() {
        return hasMine;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    public int getFlag() {
        return flag;
    }

    public int getNeighbourMineCount() {
        int totalMines = 0;
        for (Cell neighbour : neighbourList) {
            if (neighbour.getHasMine()) {
                totalMines++;
            }
        }
        return totalMines;
    }

    public void open() throws MineExplodedException, WonGameException {
        if (!isOpen && (flag != Cell.FLAG)) {
            // If this cell contains a mine, we'll throw an exception.
            isOpen = true;
            if (hasMine) {
                throw new MineExplodedException();
            }
            // Open the current cell and let the board and the graphical
            // section know about it through their listeners.
            cellToViewerListener.cellChanged();
            cellToBoardListener.cellChanged();
            // If our neighbours don't have mines, we'll open them as well.
            if (getNeighbourMineCount() == 0) {
                for (Cell neighbour : neighbourList) {
                    neighbour.open();
                }
            }
        }
    }

    public void openNeighbours() throws MineExplodedException, WonGameException {
        if (this.isOpen) {
            if (getNeighbourMineCount() <= getNeighbourFlagCount()) {
                for (Cell neighbour : neighbourList) {
                    neighbour.open();
                }
            }
        }
    }

    public int getNeighbourFlagCount() {
        int flags = 0;
        for (Cell neighbour : neighbourList) {
            if (neighbour.getFlag() == FLAG) {
                flags++;
            }
        }
        return flags;
    }

    public void forceOpen() {
        isOpen = true;
        cellToViewerListener.cellChanged();
    }

    public void switchFlag() {
        if (!isOpen) {
            switch (flag) {
                case NO_FLAG:
                    flag = FLAG;
                    break;
                case FLAG:
                    flag = DOUBT_FLAG;
                    break;
                case DOUBT_FLAG:
                    flag = NO_FLAG;
                    break;
                default:
                    break;
            }
        }
        cellToViewerListener.cellChanged();
    }

    public void setCTBListener(CellToBoardListener cellToBoardListener) {
        this.cellToBoardListener = cellToBoardListener;
    }

    public void setCTVListener(CellToViewerListener cellToViewerListener) {
        this.cellToViewerListener = cellToViewerListener;
    }
}
