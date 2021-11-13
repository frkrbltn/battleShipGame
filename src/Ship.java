import java.util.*;

public class Ship {

    private int length;
    private int hits;
    private boolean isHorizontal;
    private int startRow;
    private int startCol;



    public Ship(int length, boolean isHorizontal, int startRow, int startCol)
    {


        if (length < 1) {
            throw new IllegalArgumentException("Invalid length");
        } else if(startRow < 0) {
            throw new IllegalArgumentException("Invalid row");
        } else if(startCol < 0) {
            throw new IllegalArgumentException("Invalid col");
        } else {
            /* The length of the ship */
            this.length = length;
            /* The number of times the ship has been hit */
            this.hits = 0;
            /* if it is horizontal is true
            if it is vertical is false */
            this.isHorizontal = isHorizontal;
            /* The rows of the game board */
            this.startRow = startRow;
            /* The columns of the game board */
            this.startCol = startCol;
        }


    }

    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    public int getLength() {
        return this.length;
    }

    public int getStartCol() {
        return this.startCol;
    }

    public int getStartRow() {
        return this.startRow;
    }

    public boolean isSunk()
    {
        return this.hits == this.length;
    }

    public void hit() {
        if (this.hits >= length) {
            throw new IllegalStateException("Too many hits");
        } else{
            this.hits++;
        }
    }

    @Override
    public boolean equals(Object o) {
        boolean isEquals = false;
        if(o instanceof Ship) {
            Ship otherShip = (Ship) o;
            if (length == otherShip.length && startRow == otherShip.startRow &&
                isHorizontal == otherShip.isHorizontal && startCol == otherShip.startCol) {
                isEquals = true;
            }
        }
        return isEquals;
    }

    @Override
    public String toString() {
        String s =  "Length: " + length +
                "\nLocation: (" + startRow + "," + startCol + ")";
                if (isHorizontal == true)
                    s = s + "\nOrientation: " + "Horizontal";
                else
                    s = s + "\nOrientation: " + "Vertical";

                s = s + "\nNumber of hits: " + hits +
                "\nSunk: " + isSunk();

                return s;
    }
}
