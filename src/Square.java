import java.util.*;

/**
 * The Square class represents the location in the baord
 * @author Furkan Karabulut
 */
public class Square {

    /** If the square has been hit it is true otherwise false*/
    private boolean hasBeenHit;
    /** If there is a ship in the square  */
    private Ship ship;

    /**
     * This method is the constructor of the square class
     * which is default and already initialize the private values
     */
    public Square() {
        this.hasBeenHit = false;
        this.ship = null;
    }

    /**
     * This method will give information about the
     * square if it is been hit or not
     * @return hasBeenHit will return the true if is hit otherwise false
     */
    public boolean hasBeenHit() {
        return hasBeenHit;
    }

    /**
     * this method add the ship to the square class.
     * @param ship is the object comes from Ship class.
     */
    public void addShip(Ship ship) {

        this.ship = ship;
    }

    /**
     *
     * @return hasShip true if the square contains the ship.
     */
    public boolean hasShip() {
        boolean hasShip;
        if (this.ship != null) {
            hasShip = true;
        } else {
            hasShip = false;
        }
        return hasShip;
    }

    /**
     * This method will give information about the square if it has
     * a ship or not
     * @return ship the reference to the ship located in the square.
     */
    public Ship getShip() {
        if (this.ship != null) {
            return ship;
        } else {
            return null;
        }
    }

    /**
     * This method update the square if it is hit or not
     * if the ship occupies the square then this method will call
     * the method Ship.hit() method from the ship class to let it know
     * that the ship has been hit.
     * @throws IllegalStateException if the square is already been hit.
     */
    public void fireAt() {
        if(this.ship != null) {
            if(!this.hasBeenHit) {
                if (!this.ship.isSunk()) {
                    this.ship.hit();
                }
                this.hasBeenHit = true;
            }
            else
                throw new IllegalStateException("Already hit");
        }
        else
        {
            if(!this.hasBeenHit) {
                this.hasBeenHit = true;
            }
            else
                throw new IllegalStateException("Already hit");
        }

    }

    /**
     * This method will compare two square object and if they have
     * the same corresponding values it will return correct otherwise false.
     * @param o is the object is created and it will be compared to the other
     *          object if they are from the same object type or not
     * @return isEqual will be true if those two objects are the same ot not.
     */
    @Override
    public boolean equals (Object o){
        boolean isEqual = false;
        if (o instanceof Square) {
            Square otherSquare = (Square) o;
            if (hasBeenHit == otherSquare.hasBeenHit && ship == otherSquare.ship) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    /**
     * This method will return String indication the state of the square
     * The string will be dash - if the square does not contain a ship and
     * it is not been hit
     * The string will be W for white if the square does not contain a ship,
     * but it is been hit
     * The string will be R for Red if the square contains a ship and it
     * is been hit.
     * The string will be the length of the ship if the square contains a ship
     * and it is not been hit.
     * @return s the string to be return based on the above explanation.
     */
    @Override
    public String toString () {
        String s = "";
        if (this.ship == null && this.hasBeenHit == false) {
            s = "-";
        } else if (this.ship == null && this.hasBeenHit == true) {
            s = "W";
        } else if (this.ship != null && this.hasBeenHit == true) {
            s = "R";
        } else if (this.ship != null && this.hasBeenHit == false) {
            int l = ship.getLength();
            s = String.valueOf(l);
        }
        return s;
    }

}
