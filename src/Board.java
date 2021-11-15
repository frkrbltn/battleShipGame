import java.util.*;

public class Board {

    private int numberOfRows;
    private int numberOfColumns;
    private Square[][] grid;
    private int maximumNumberOfShips;
    private Ship[] ships;
    private int numberOfShips;

    public Board(int numberOfRows, int numberOfColumns, int maximumNumberOfShips) {

        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.maximumNumberOfShips = maximumNumberOfShips;

        if(this.numberOfRows < 1) {
            throw new IllegalArgumentException("Invalid rows");
        } else if(this.numberOfColumns < 1) {
            throw new IllegalArgumentException("Invalid cols");
        } else if(this.maximumNumberOfShips < 1) {
            throw new IllegalArgumentException("Invalid ships");
        }
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfShips() {
        return numberOfShips;
    }

    public boolean addShip(int length, boolean isHorizontal, int startRow, int startCol) {

        if (length < 1) {
            throw new IllegalArgumentException("Invalid length");
        } else if (startRow < 0 || startRow >= this.numberOfRows) {
            throw new IllegalArgumentException("Invalid row");
        } else if (startCol < 0 || startCol >= this.numberOfColumns) {
            throw new IllegalArgumentException("Invalid length");
        } else{
            if (isHorizontal == true && this.ships.length + startCol <= numberOfColumns) {
                Ship newShip = new Ship(length, isHorizontal, startRow, startCol);
                this.ships[this.ships.length]=newShip;
                return true;
            } else if (isHorizontal == false && this.ships.length + startRow <= numberOfRows) {
                Ship newShip = new Ship(length, isHorizontal, startRow, startCol);
                this.ships[this.ships.length]=newShip;
                return true;
            }
        }
        return false;
    }

    public Ship getShip(int row, int col) {
        if(row < 0 || row >= numberOfRows) {
            throw new IllegalArgumentException("Invalid row");
        } else if(col < 0 || col >= numberOfColumns) {
            throw new IllegalArgumentException("Invalid col");
        }
        for (int i = 0; i < ships.length; i++) {
            if(ships[i].isHorizontal()== true) {
                if (ships[i].getStartRow() <= row && row <= ships[i].getStartRow()+ships[i].getLength()){
                    if (ships[i].getStartCol() == col){
                        return this.ships[i];
                    }
                }
            } else if(ships[i].isHorizontal() == false) {
                if (ships[i].getStartCol() <= col && col <= ships[i].getStartCol()+ships[i].getLength()){
                    if (ships[i].getStartRow() == row){
                        return this.ships[i];
                    }
                }
            }
        }
        return null;
    }

    public Ship[] getShips() {
        return this.ships;
    }

    public boolean fireAtLocation(int row,int col) {
        if(row < 0 || row >= numberOfRows) {
            throw new IllegalArgumentException("Invalid row");
        } else if(col < 0 || col >= numberOfColumns) {
            throw new IllegalArgumentException("Invalid col");
        }
        boolean x = false;
        if (grid[row][col].hasBeenHit() == false) {
            grid[row][col].fireAt();
            x = true;
        }else if(grid[row][col].hasBeenHit() == true) {
            x = false;
        }
        return x;
    }

    public boolean hasBeenHit(int row,int col) {
        if(row < 0 || row >= numberOfRows) {
            throw new IllegalArgumentException("Invalid row");
        } else if(col < 0 || col >= numberOfColumns) {
            throw new IllegalArgumentException("Invalid col");
        }
        boolean y = false;
        if(grid[row][col].hasBeenHit() == false){
            y = true;
        } else{
            y = false;
        }
        return y;
    }

    public boolean areAllShipsSunk() {
        boolean z = false;

        for (int i = 0; i < this.numberOfShips; i++) {
            if(ships[i].isSunk() == false) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @Override
    public String toString() {
        String dash = "";
//        String[][] myBoard = new String[this.numberOfRows][this.numberOfColumns];
//        for(int i = 1; i <= myBoard.length; i++) {
//            for(int j = 0; j < myBoard[0].length; j++) {
//                System.out.print(dash);
//            }
//            System.out.println();
//        }
//       for(int i = 0; i < ships.length; i++) {
//           if(ships[i].isHorizontal() == true) {
//               for (int j = 0; j < ships[i].getLength(); j++)
//                   myBoard[ships[i].getStartRow()][ships[i].getStartCol()+i] =
//                           grid[ships[i].getStartRow()][ships[i].getStartCol()+i].toString();
//           } else {
//               for (int j = 0; j < ships[i].getLength(); j++)
//                   myBoard[ships[i].getStartRow() + i ][ships[i].getStartCol()] =
//                           grid[ships[i].getStartRow() + i][ships[i].getStartCol()].toString();
//           }
//       }
        for(int i = 1; i <= this.numberOfRows; i++) {
            for(int j = 0; j < this.numberOfColumns; j++) {
                dash = dash + grid[i][j].toString();
            }
            dash = dash + "\n";
        }

       return dash;
    }

}
