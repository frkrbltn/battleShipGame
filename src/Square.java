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

    public boolean hasShip() {
        boolean hasShip = false;
    }

    public Ship getShip()
    {
        Ship obj = null;
        return obj;
    }

    public void fireAt() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return hasBeenHit == square.hasBeenHit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasBeenHit);
    }

    @Override
    public String toString() {
        return "Square{}";
    }
}
