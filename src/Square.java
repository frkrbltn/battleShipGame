import java.util.*;

public class Square {

    private boolean hasBeenHit;

    public Square()
    {

    }

    public boolean hasBeenHit() {
        return hasBeenHit;
    }

    public void addShip(Ship obj) {

    }

    public boolean hasShip() {
        return hasBeenHit;
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
