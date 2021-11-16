import java.util.*;

public class Board {

    /** numberOfRows represent the 2D arrays of square object's rows*/
    private int numberOfRows;
    /** numberOfColumns represent the number of columns in 2D arrays of square object*/
    private int numberOfColumns;
    /** 2D array of square*/
    private Square[][] grid;
    /** Integer that represent the maximum number of ships*/
    private int maximumNumberOfShips;
    /** An array of Ships*/
    private Ship[] ships;
    /** The number of ships on the board*/
    private int numberOfShips;

    /**
     * This method is the constructor, and it initializes the parameters and create
     * the necessary objects for fields.
     * @param numberOfRows will be the number of rows on the board
     * @param numberOfColumns will be the numbers of cols on the board
     * @param maximumNumberOfShips will be the maximum number ship on the board.
     * @throws IllegalArgumentException when the number of rows is less than 1
     * @throws IllegalArgumentException when the number of cols is less than 1
     * @throws IllegalArgumentException when the maximum number of ship is less than 1
     */
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
            for (int i = 0; i < this.numberOfRows; i++) {
                for (int j = 0; j < this.numberOfColumns; j++) {
                    grid[i][j] = new Square();
                }
            }

            ships = new Ship[this.maximumNumberOfShips];
            numberOfShips = 0;
        }
    }

    /**
     *
     * @return numberOfRows in the board.
     */
    public int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     *
     * @return numberOfColumns in the board
     */
    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    /**
     *
     * @return numberOfShips on the baord
     */
    public int getNumberOfShips() {
        return numberOfShips;
    }

    /**
     * This method creates ships and adds to the board. This ship
     * should be added correctly so the ships do not come on each other
     * This method returns true if all ships are added appropriately.
     * @param length is the length of the ship
     * @param isHorizontal is the orientation of the ship if it treu
     *                     it is horizontal otherwise vertical
     * @param startRow is the number of where the ships row starts
     * @param startCol is the number of where the ship's col start
     * @return true if the ships are added correctly.
     * @throws IllegalArgumentException if the length of the ship is less than 1
     * @throws IllegalArgumentException if the start row of the ship is less than 0
     *                                  and bigger than number of rows of the board.
     * @throws IllegalArgumentException if the start col of the ship is less than 0
     *                                  and bigger than the number of the col of the board
     *
     */
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

                for (int i = 0; i < length; i++) {
                    if ( grid[startRow][startCol + i].getShip() != null)
                        return false;
                }


                Ship newShip = new Ship(length, isHorizontal, startRow, startCol);
                for (int i = 0; i < this.maximumNumberOfShips; i++)
                {
                    if (this.ships[i] == null)
                    {
                        this.ships[i] = newShip;
                        this.numberOfShips++;
                        break;
                    }
                }

                for (int i=0; i<length;i++) {
                    grid[startRow][startCol + i].addShip(newShip);
                }
                return true;
            } else if (isHorizontal == false && (length + startRow) <= numberOfRows) {

                for (int i = 0; i < length; i++) {
                    if ( grid[startRow + i][startCol].getShip() != null)
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
                for (int i=0;i<length;i++){
                    grid[startRow + i][startCol].addShip(newShip);
                }
                return true;
            }
        }
        return false;
    }


    /**
     *  Returns the Ship contained in the given row and column of the Board
     * @param row represent the ship in the given row
     * @param col represent the ship in the given col
     * @return the array of ship.
     * @throws IllegalArgumentException if the row is less than 0 or bigger or
     *                                  equals the number of rows
     * @throws IllegalArgumentException if the col is less than 0 or bigger or
     *                                  equals the number of cols
     */
    public Ship getShip(int row, int col) {
        if(row < 0 || row >= numberOfRows) {
            throw new IllegalArgumentException("Invalid row");
        } else if(col < 0 || col >= numberOfColumns) {
            throw new IllegalArgumentException("Invalid col");
        }
        for (int i = 0; i < ships.length; i++) {
            if(ships[i].isHorizontal()== true && grid[row][col + i] != null) {
                if (ships[i].getStartRow() <= row && row <= ships[i].getStartRow()+ships[i].getLength()){
                    if (ships[i].getStartCol() == col){
                        return this.ships[i];
                    } else {
                        return null;
                    }
                }
            } else if(ships[i].isHorizontal() == false && grid[row + i][col] != null) {
                if (ships[i].getStartCol() <= col && col <= ships[i].getStartCol()+ships[i].getLength()){
                    if (ships[i].getStartRow() == row){
                        return this.ships[i];
                    } else {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    /**
     * This method returns the array of Ships
     * @return the array of Ships
     */
    public Ship[] getShips() {

        return this.ships;
    }

    /**
     * This method provides the fire at the given square
     * if it is been hit, it cannot be hit again, and it will return false
     * if it is not been hit, it can be hit, and it will return true
     *
     * @param row is the given row on the board
     * @param col is the given col on the board
     * @return true if it is hit true otherwise false.
     */
    public boolean fireAtLocation(int row,int col) {
        if(row < 0 || row >= numberOfRows) {
            throw new IllegalArgumentException("Invalid row");
        } else if(col < 0 || col >= numberOfColumns) {
            throw new IllegalArgumentException("Invalid col");
        }
        if (grid[row][col].hasBeenHit() == false) {
            grid[row][col].fireAt();
            return true;
        }else if(grid[row][col].hasBeenHit() == true) {
            return false;
        }
        return false;
    }

    /**
     * this method will give information about specified square if it is been hit or not
     * @param row is the given row on the board
     * @param col is the given col on the board
     * @return true if it is been hit otherwise false.
     */
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

    /**
     * This method tell us that if all ships in the board are sunk or not
     * @return z if it true, all ships are sunk otherwise false.
     */
    public boolean areAllShipsSunk() {
        boolean z = false;

        for (int i = 0; i < this.numberOfShips; i++) {
            if(ships[i].isSunk() == false) {
                z = false;
            } else {
                z = true;
            }
        }
        return z;
    }

    /**
     * This method is overriding the toString method.
     * @return
     */
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
