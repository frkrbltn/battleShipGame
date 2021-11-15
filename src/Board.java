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
        } else {
            grid = new Square[this.numberOfRows][this.numberOfColumns];
            for (int i=0; i< this.numberOfRows;i++) {
                for (int j=0;j < this.numberOfColumns;j++) {
                    grid[i][j] = new Square();
                }
            }

            ships = new Ship[this.maximumNumberOfShips];

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
            throw new IllegalArgumentException("Invalid col");
        } else{
            if (this.maximumNumberOfShips == this.numberOfShips)
                return false;

            if (isHorizontal == true && (length + startCol) <= numberOfColumns) {

                for (int i=0; i<length;i++) {
                   if ( grid[startRow][startCol + i].getShip() != null)
                       return false;
                }


                Ship newShip = new Ship(length, isHorizontal, startRow, startCol);
                for (int i=0;i<this.maximumNumberOfShips;i++)
                {
                    if (this.ships[i] == null)
                    {
                        this.ships[i]=newShip;
                        this.numberOfShips++;
                        break;
                    }
                }

                //TODO:Custom code that might be correct!
                for (int i=0; i<length;i++) {
                    grid[startRow][startCol + i].addShip(newShip);
                }
                return true;
            } else if (isHorizontal == false && (length + startRow) <= numberOfRows) {

                for (int i=0; i<length;i++) {
                    if ( grid[startRow+i][startCol].getShip() != null)
                        return false;
                }

                Ship newShip = new Ship(length, isHorizontal, startRow, startCol);
                for (int i=0;i<this.maximumNumberOfShips;i++)
                {
                    if (this.ships[i] == null)
                    {
                        this.ships[i]=newShip;
                        this.numberOfShips++;
                        break;
                    }
                }
                //TODO:Custom code that might be correct!
                for (int i=0;i<length;i++){
                    grid[startRow + i][startCol].addShip(newShip);
                }
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
        if(grid[row][col].hasBeenHit() == true){
            return true;
        } else{
            return false;
        }
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
        for(int i = 0; i < this.numberOfRows; i++) {
            for(int j = 0; j < this.numberOfColumns; j++) {
                dash = dash + grid[i][j].toString();
                if (j < this.numberOfColumns-1)
                    dash = dash + " ";
                else
                    dash = dash + "\n";
            }
        }

       return dash;
    }

}
