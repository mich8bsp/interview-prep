package ctci.oop.Q7_10_Minesweeper;

import java.util.*;
import java.util.stream.Collectors;

public class Minesweeper {

    private MinesweeperCell[][] field;
    private int cellsToOpenForWin = 0;

    private static class MinesweeperCell {
        private int row;
        private int col;
        private boolean isBomb = false;
        private boolean isMarkedAsBomb = false;
        private int neighbouringBombs = 0;
        private boolean isOpen = false;

        public MinesweeperCell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public MinesweeperCell setIsBomb(boolean isBomb) {
            this.isBomb = isBomb;
            return this;
        }

        public MinesweeperCell setNeighbouringBombs(int count) {
            this.neighbouringBombs = count;
            return this;
        }

        @Override
        public String toString() {
            if (isMarkedAsBomb) {
                return "[!]";
            }
            if (!isOpen) {
                return "[ ]";
            }
            if (isBomb) {
                return "[x]";
            }
            return "[" + neighbouringBombs + "]";
        }
    }

    private static MinesweeperCell createBombCell(int i, int j) {
        return new MinesweeperCell(i, j)
                .setIsBomb(true);
    }

    private static MinesweeperCell createNonBombCell(int i, int j) {
        return new MinesweeperCell(i, j);
    }

    public Minesweeper(int fieldSize) {
        this.field = new MinesweeperCell[fieldSize][fieldSize];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<field.length; i++){
            for(int j=0;j<field.length;j++){
                builder.append(field[i][j]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public Minesweeper initBombs(List<int[]> bombs) {
        bombs.forEach(bomb -> field[bomb[0]][bomb[1]] = createBombCell(bomb[0], bomb[1]));
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == null) {
                    field[i][j] = createNonBombCell(i, j).setNeighbouringBombs(countBombsAround(i, j));
                }
            }
        }
        this.cellsToOpenForWin = field.length * field.length - bombs.size();
        return this;
    }

    public EGameState openCell(int i, int j) {
        MinesweeperCell cell = field[i][j];
        if (cell != null) {
            return openCell(cell);
        } else {
            System.out.println("Shouldn't happen - cell " + i + ", " + j + " was null");
            return EGameState.GAME_OVER;
        }
    }

    private EGameState openCell(MinesweeperCell cell) {
        if (cell.isOpen) {
            return EGameState.ONGOING;
        }
        cell.isOpen = true;
        if (cell.isBomb) {
            return EGameState.GAME_OVER;
        }
        cell.isMarkedAsBomb = false;
        cellsToOpenForWin--;
        if(cellsToOpenForWin==0){
            return EGameState.WIN;
        }
        List<MinesweeperCell> neighbouringToOpen = getNeighboursToOpen(cell.row, cell.col);
        EGameState nextGameState = EGameState.ONGOING;
        for (MinesweeperCell minesweeperCell : neighbouringToOpen) {
            EGameState gameState = openCell(minesweeperCell);
            if(gameState.equals(EGameState.WIN)){
                nextGameState = gameState;
            }
        }
        return nextGameState;
    }

    private List<MinesweeperCell> getNeighboursToOpen(int row, int col) {
        if(countBombsAround(row, col)==0){
            return getNeighbours(row, col).stream()
                    .filter(x->!x.isBomb)
                    .filter(x->!x.isOpen)
                    .collect(Collectors.toList());
        }else{
            return Collections.emptyList();
        }
    }

    public EGameState markCell(int i, int j) {
        MinesweeperCell cell = field[i][j];
        if (cell != null && !cell.isOpen) {
            cell.isMarkedAsBomb = !cell.isMarkedAsBomb;
        }
        return EGameState.ONGOING;
    }

    private int countBombsAround(int row, int col) {
        return (int) getNeighbours(row, col)
                .stream()
                .filter(cell -> cell.isBomb)
                .count();
    }

    private List<MinesweeperCell> getNeighbours(int row, int col){
        List<int[]> coords = Arrays.asList(new int[]{row-1, col-1},
                new int[]{row-1, col},
                new int[]{row-1, col+1},
                new int[]{row, col-1},
                new int[]{row, col+1},
                new int[]{row+1, col-1},
                new int[]{row+1, col},
                new int[]{row+1, col+1});

        return coords.stream()
                .filter(coord -> isValidCell(coord[0], coord[1]))
                .map(coord -> field[coord[0]][coord[1]])
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private boolean isValidCell(int row, int col) {
        if (row < 0 || row >= field.length) {
            return false;
        }
        if (col < 0 || col >= field.length) {
            return false;
        }
        return true;
    }

    private static List<int[]> getUniqueRandomCells(int numOfCells, int size){
        Random rnd = new Random();
        int counter = 0;
        Set<int[]> indicesSet = new HashSet<>();
        while(counter<numOfCells){
            int row = rnd.nextInt(size);
            int col = rnd.nextInt(size);
            int[] indices = new int[]{row, col};
            if(!indicesSet.contains(indices)){
                indicesSet.add(indices);
                counter++;
            }
        }
        return new ArrayList<>(indicesSet);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter minesweeper field size: ");
        int fieldSize = scan.nextInt();
        System.out.println("Enter number of mines: ");
        int mines = scan.nextInt();


        Minesweeper minesweeper = new Minesweeper(fieldSize).initBombs(getUniqueRandomCells(mines, fieldSize));
        System.out.println(minesweeper);

        System.out.println("Enter commands, options are: o_row_col for opening, m_row_col for marking: ");
        while(true){
            String command = scan.next();
            String[] commandParsed = command.split("_");
            int row = Integer.parseInt(commandParsed[1]);
            int col = Integer.parseInt(commandParsed[2]);
            EGameState nextState = EGameState.ONGOING;
            if(commandParsed[0].equals("o")){
                nextState = minesweeper.openCell(row, col);
            }else if(commandParsed[1].equals("m")){
                nextState = minesweeper.markCell(row, col);
            }else{
                System.out.println("Unrecognized command " + command);
                System.exit(1);
            }
            System.out.println(minesweeper);
            if(nextState.equals(EGameState.GAME_OVER)){
                System.out.println("GAME OVER");
                System.exit(0);
            }
            if(nextState.equals(EGameState.WIN)){
                System.out.println("YOU WON!");
                System.exit(0);
            }
        }

    }

}
