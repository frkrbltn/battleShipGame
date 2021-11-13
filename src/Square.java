import java.util.*;

public class Square {

    private boolean hasBeenHit;
    private Ship ship;

    public Square() {
        this.hasBeenHit = false;
        this.ship = null;
    }

    public boolean hasBeenHit() {
        return hasBeenHit;
    }

    public void addShip(Ship ship) {

        this.ship=ship;
    }

    public boolean hasShip() {
        boolean hasShip;
        if (this.ship != null) {
            hasShip = true;
        } else {
            hasShip = false;
        }
        return hasShip;
    }

    public Ship getShip() {
        if (this.ship != null) {
            return ship;
        } else {
            return null;
        }
    }

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
