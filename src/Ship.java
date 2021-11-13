import java.util.*;

public class Ship {

    private int length;
    private int hits;
    private boolean isHorizontal;
    private int startRow;
    private int startCol;

    public Ship(int x,boolean y,int z,int d)
    {

    }


    public boolean isHorizontal() {
        return isHorizontal;
    }

    public int getLength() {
        return length;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getStartRow() {
        return startRow;
    }

    public boolean isSunk()
    {
        return true;
    }

    public void hit()
    {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return length == ship.length && hits == ship.hits && isHorizontal == ship.isHorizontal && startRow == ship.startRow && startCol == ship.startCol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, hits, isHorizontal, startRow, startCol);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "length=" + length +
                ", hits=" + hits +
                ", isHorizontal=" + isHorizontal +
                ", startRow=" + startRow +
                ", startCol=" + startCol +
                '}';
    }
}
