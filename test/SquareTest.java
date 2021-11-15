import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test class will test the method in
 * the Square class.
 * @author Furkan Karabulut
 */
public class SquareTest {

    /** Battleship.Square object */
    private Square square;

    /**
     * Creates fields before each test is executed
     */
    @BeforeEach
    public void setUp() {
        square = new Square();
    }

    /**
     * Tests constructor
     */
    @Test
    public void testConstructor() {
        assertFalse(square.hasBeenHit());
        assertNull(square.getShip());
        assertFalse(square.hasShip());
    }

    /**
     * Tests addShip with hasShip and getShip methods.
     */
    @Test
    public void testAddShip() {
        // TODO: Replace the fail() statement with the following:
        // Create a ship and add it to the square. Then test the hasShip() and getShip() methods.
        Ship ship = new Ship(3, true, 3, 1);
        square.addShip(ship);
        assertTrue(square.hasShip(), "it should be true cause it has a ship");
        assertTrue(square.getShip().equals(ship), "it needs to return ship");
    }

    @Test
    public void testFireAt() {
        // TODO: Replace the fail() statement with the following:
        // Fire at the square. Then test the hasBeenHit() method.
        assertFalse(square.hasBeenHit(), "it is been not hit");
    }

    /**
     * Tests equals() method for Squares without ships
     */
    @Test
    public void testEqualsNoShip() {
        assertTrue(square.equals(square), "square equals itself");
        Square otherSquare = new Square();
        assertTrue(square.equals(otherSquare), "empty square equals another empty square");
        square.fireAt();
        assertFalse(square.equals(otherSquare),
                "Battleship.Square with no ship hit compared with square with no ship and not hit");
        otherSquare.fireAt();
        assertTrue(square.equals(otherSquare),
                "Battleship.Square with no ship hit compared with another square with no ship and hit");
        assertFalse(square.equals(null), "square compared to null object");
        assertFalse(square.equals("square"), "squared compared to String");

    }

    @Test
    public void testEqualsShip() {
        // TODO: Replace the fail() statement with the following:
        // Create a ship and add it to the square and then test the equals() method
        // with another Battleship.Square without a ship.
        // Then add the same ship to the other Battleship.Square and test the equals() method  again.
        // Then fire at the square and test the equals() method again.
        // Then fire at the other Battleship.Square and test the equals() method again.
        Ship ship2 = new Ship(3, true, 3, 1);
        Square square2 = new Square();

        square.addShip(ship2);
        assertFalse(square.equals(square2.equals(ship2)), "They are not equal");
        square2.addShip(ship2);
        assertTrue(square.equals(square2), "They are now equal");

        square.fireAt();
        assertFalse(square.equals(square2), "it should be false");
        square2.fireAt();
        assertTrue(square.equals(square2), "Now, it should be true");
    }

    /**
     * Tests toString() method for Squares without ships
     */
    @Test
    public void testToStringNoShip() {
        assertEquals("-", square.toString(), "Test toString() with no ship and not hit");
        square.fireAt();
        assertEquals("W", square.toString(), "Test toString() with no ship and has been hit");
    }

    /**
     * Tests toString() method for Squares with ships
     */
    @Test
    public void testToStringWithShip() {
        // TODO: Replace the fail() statement with the following:
        // Create a ship and add it to the square. Then test the toString() method.
        // Then fire at the square and test the toString() method again.
        Ship ship = new Ship(2, false, 1, 2);
        square.addShip(ship);
        assertEquals("2",square.toString(), "the ship is not null and not been fired\n " +
                                                             "so it needs to give only length");
        square.fireAt();
        assertEquals("R", square.toString(), "the ship is not null and its been hit\n" +
                                                            "Not it should give the Red");

    }


    /**
     * Tests exception
     */
    @Test
    public void testException() {

        // Testing when square is fired at twice
        square.fireAt();
        Exception exception = assertThrows(IllegalStateException.class,
                () -> square.fireAt(), "Fired at twice");
        assertEquals("Already hit", exception.getMessage(),
                "Testing fired at twice message");
    }

}