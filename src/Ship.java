import java.util.*;

/**
 * This program will give individual information about the
 * ship such as length, orientation, starting row and column
 * as well as how many times ship get hit and after these hits
 * if the ship is sunk or not.
 * @author Furkan Karabulut
 */
public class Ship {

    private int length;
    private int hits;
    private boolean isHorizontal;
    private int startRow;
    private int startCol;

    /**
     *
     * @param length is the length of the ship and private
     * @param isHorizontal will be orientation if it is vertical or horizontal
     * @param startRow will be ship's starting row number on the board
     * @param startCol will be ship's starting col number on the board
     * @throws IllegalArgumentException if the length of the ship is less than 1
     * @throws IllegalArgumentException if the start row of the ship is less than 0
     * @throws IllegalArgumentException if the start col of the ship is less than 0
     */
    public Ship(int length, boolean isHorizontal, int startRow, int startCol) {


        if (length < 1) {
            throw new IllegalArgumentException("Invalid length");
        } else if (startRow < 0) {
            throw new IllegalArgumentException("Invalid row");
        } else if (startCol < 0) {
            throw new IllegalArgumentException("Invalid col");
        } else {
            /* The length of the ship */
            this.length = length;
            /* The number of times the ship has been hit to initialize */
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

    /**
     *
     * @return will return the orientation of the ship
     */
    public boolean isHorizontal() {
        return this.isHorizontal;
    }

    /**
     *
     * @return will return the length of the ship
     */

    public int getLength() {
        return this.length;
    }

    /**
     *
     * @return will return the start number of column of the ship
     */

    public int getStartCol() {
        return this.startCol;
    }

    /**
     *
     * @return will return the start number of row of the ship
     */

    public int getStartRow() {
        return this.startRow;
    }

    /**
     *
     * @return will return if the ship is sunk or not
     */

    public boolean isSunk() {
        return this.hits == this.length;
    }

    /**
     *  This method will update the hits on the ship
     * @throws IllegalStateException if the ship gets hits more than length
     */

    public void hit() {
        if (this.hits >= length) {
            throw new IllegalStateException("Too many hits");
        } else {
            this.hits++;
        }
    }

    /**
     * This method will compare two objects if they are equals to each other
     * it will return the true otherwise false.
     * @param o is the object created which will be compared if o is instance of
     *          object type with other object
     * @return isEquals if two objects are the same.
     */
    @Override
    public boolean equals(Object o) {
        boolean isEquals = false;
        if (o instanceof Ship) {
            Ship otherShip = (Ship) o;
            if (length == otherShip.length && startRow == otherShip.startRow &&
                    isHorizontal == otherShip.isHorizontal && startCol == otherShip.startCol) {
                isEquals = true;
            }
        }
        return isEquals;
    }

    /**
     * This method will overriding the object method to show as a string on terminal
     * instead of showing its ID number
     * @return s is the initialization for a string and it will be added by
     * object parameters to give information about the object.
     */
    @Override
    public String toString() {
        String s = "Length: " + length +
                "\nLocation: (" + startRow + "," + startCol + ")";
        if (isHorizontal == true) {
            s = s + "\nOrientation: " + "Horizontal";
        } else {
            s = s + "\nOrientation: " + "Vertical";
        }
        s = s + "\nNumber of hits: " + hits +
                "\nSunk: " + isSunk();

        return s;
    }
}