import java.util.*;

public class Square {

    private boolean hasBeenHit;
    private Ship ship;

    public Square( boolean hasBeenHit, Ship ship) {
        this.hasBeenHit = hasBeenHit;
        this.ship = ship;
    }

    public boolean hasBeenHit() {
        return hasBeenHit;
    }

    public void addShip(Ship ship) {

        int length = ship.getLength();
        boolean orientation = ship.isHorizontal();
        int row = ship.getStartRow();
        int col = ship.getStartCol();
    }

    public void hasShip() {
        boolean hasShip;
        if(this.ship != null) {
             hasShip = true;
        } else {
             hasShip = false;
        }
    }

    public Ship getShip() {
        if(this.ship != null) {
            return ship;
        } else {
            return null;
        }
    }

    public void fireAt() {
        this.hasBeenHit = true;
        ship.hit();
        throw new IllegalStateException("Already hit");
    }

    @Override
    public boolean equals(Object o) {
        boolean isEqual = false;
        if (o instanceof Square) {
            Square otherSquare = (Square) o;
            if (hasBeenHit == otherSquare.hasBeenHit && ship == otherSquare.ship) {
                return isEqual = true;
            }
        }
        return isEqual;
    }

    @Override
    public String toString() {
        String s = "";
        if(this.ship == null && this.hasBeenHit == false) {
            s = "-";
        } else if(this.ship == null && this.hasBeenHit == true) {
            s = "W";
        } else if(this.ship != null && this.hasBeenHit == true) {
            s = "R";
        } else if(this.ship != null && this.hasBeenHit == false) {
            int l = ship.getLength();
            s = String.valueOf(l);
        }
        return s;
    }
}
