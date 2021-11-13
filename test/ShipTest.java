import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// TODO Add javadoc
public class ShipTest {

    /** Ship of length two */
    private Ship shipLengthTwo;

    // TODO: Add another ship

    /**
     * Creates fields before each test case is executed
     */
    @BeforeEach
    public void setUp() {
        shipLengthTwo = new Ship(2, false, 1, 2);
        // TODO construct another ship
    }

    /**
     * Tests getLength method
     */
    @Test
    public void testGetLength() {
        assertEquals(2, shipLengthTwo.getLength(), "Check length of 2");
    }

    // TODO Test getLength for added ship

    /**
     * Tests isHorizontal method
     */
    @Test
    public void testIsHorizontal() {
        assertFalse(shipLengthTwo.isHorizontal(), "Check vertical");
    }

    // TODO Test isHorizontal for added ship

    /**
     * Tests getStartRow method
     */
    @Test
    public void testGetStartRow() {
        assertEquals(1, shipLengthTwo.getStartRow(),
                "Check start row of ship 2");
    }

    // TODO Test getStartRow for added ship

    /**
     * Tests getStartCol method
     */
    @Test
    public void testGetStartCol() {
        assertEquals(2, shipLengthTwo.getStartCol(),
                "Check start col of ship 2");
    }

    // TODO Test getStartCol for added ship

    /**
     * Tests isSunk method
     */
    @Test
    public void testIsSunkHit() {
        assertFalse(shipLengthTwo.isSunk(), "Not sunk - Hit: 0 - Ship 2");
        shipLengthTwo.hit();
        assertFalse(shipLengthTwo.isSunk(), "Not sunk - Hit: 1 - Ship 2");
    }

    // TODO Test isSunk for added ship

    /**
     * Tests equals method
     */
    @Test
    public void testEquals() {
        assertTrue(shipLengthTwo.equals(shipLengthTwo), "Equal to itself");
        assertTrue(shipLengthTwo.equals(new Ship(2, false, 1, 2)),
                "Equal to ship with same parameters");
    }

    // TODO Test equals for added ship

    /**
     * Tests toString method
     */
    @Test
    public void testToString() {
        assertEquals(
                "Length: 2\n" + "Location: (1,2)\n" + "Orientation: Vertical\n"
                        + "Number of hits: 0\n" + "Sunk: false",
                shipLengthTwo.toString(), "String for Ship 2");
    }

    // TODO Test toString for added ship

    /**
     * Tests exceptions
     */
    @Test
    public void testExceptions() {
        // Testing constructor with invalid length
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Ship(0, false, 0, 0), "Constructor length 0");
        assertEquals("Invalid length", exception.getMessage(),
                "Testing length 0 message");

        // Testing constructor with invalid start row
        exception = assertThrows(IllegalArgumentException.class,
                () -> new Ship(10, false, -1, 0), "Constructor invalid row");
        assertEquals("Invalid row", exception.getMessage(),
                "Testing invalid row message");

        // Testing constructor with invalid start col
        exception = assertThrows(IllegalArgumentException.class,
                () -> new Ship(10, false, 0, -1), "Constructor invalid col");
        assertEquals("Invalid col", exception.getMessage(),
                "Testing invalid col message");

        // Testing when hit after ship is sunk
        shipLengthTwo.hit();
        shipLengthTwo.hit();
        exception = assertThrows(IllegalStateException.class,
                () -> shipLengthTwo.hit(), "Hit too many times");
        assertEquals("Too many hits", exception.getMessage(),
                "Testing hit too many times message");
    }

}