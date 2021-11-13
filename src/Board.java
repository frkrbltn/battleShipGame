import java.util.*;

public class Board {

    private int numberOfRows;
    private int numberOfColumns;
    private int maximumNumberOfShips;
    private int numberOfShips;

    public Board(int x, int y, int z)
    {

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

    public boolean addShip(int x,boolean y,int z,int d)
    {
        return true;
    }

    public Ship getShip(int x, int y)
    {
        Ship obj = null;
        return obj;
    }

    public Ship[] getShips()
    {
        Ship[] obj = new Ship[100];
        return obj;
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
