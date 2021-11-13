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

    public Ship getShip(int x, int y)
    {
        Ship obj = null;
        return obj;
    }

    public Ship[] getShips()
    {
        return this.ships;
    }

    public boolean fireAtLocation(int x,int y)
    {
        return true;
    }

    public boolean hasBeenHit(int x,int y)
    {
        return true;
    }

    public boolean areAllShipsSunk()
    {
        return true;
    }

    @Override
    public String toString() {
        return "Board{" +
                "numberOfRows=" + numberOfRows +
                ", numberOfColumns=" + numberOfColumns +
                ", maximumNumberOfShips=" + maximumNumberOfShips +
                ", numberOfShips=" + numberOfShips +
                '}';
    }
}
