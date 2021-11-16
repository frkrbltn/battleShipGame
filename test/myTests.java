import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class myTests {

    /** Our Test Board Object */
    private Board board;

    /**
     * Creates fields before each test is executed
     */
    @BeforeEach
    public void setUp() {
        board = new Board(8, 8, 4);
    }

    @Test
    public void testToStringNoShips() {
        String exp =  "- - - - - - - -\n" + "- - - - - - - -\n"
                    + "- - - - - - - -\n" + "- - - - - - - -\n"
                    + "- - - - - - - -\n" + "- - - - - - - -\n"
                    + "- - - - - - - -\n" + "- - - - - - - -\n";
        assertEquals(exp, board.toString(), "Board without ships or hits");
    }

    /**
     * Test toString for board with no ships and location hit
     */
    @Test
    public void testToStringNoShipsLocationHit() {
        board.fireAtLocation(0, 1);
        String exp =  "- W - - - - - -\n" + "- - - - - - - -\n"
                + "- - - - - - - -\n" + "- - - - - - - -\n"
                + "- - - - - - - -\n" + "- - - - - - - -\n"
                + "- - - - - - - -\n" + "- - - - - - - -\n";
        assertEquals(exp, board.toString(), "Board without ships or hits");
    }
    @Test
    public void testToStringaddShip() {
        board.addShip(4,true,0,0 );
        String exp =  "4 4 4 4 - - - -\n" + "- - - - - - - -\n"
                + "- - - - - - - -\n" + "- - - - - - - -\n"
                + "- - - - - - - -\n" + "- - - - - - - -\n"
                + "- - - - - - - -\n" + "- - - - - - - -\n";
        assertEquals(exp, board.toString(), "Board without ships or hits");
    }

    @Test
    public void testToStringaddShip2() {
        board.addShip(2,true,2,3 );
        String exp =  "- - - - - - - -\n" + "- - - - - - - -\n"
                + "- - - 2 2 - - -\n" + "- - - - - - - -\n"
                + "- - - - - - - -\n" + "- - - - - - - -\n"
                + "- - - - - - - -\n" + "- - - - - - - -\n";
        assertEquals(exp, board.toString(), "Board without ships or hits");
    }

    @Test
    public void testToStringaddShip3() {
        board.addShip(3,false,4,6 );
        String exp =  "- - - - - - - -\n" + "- - - - - - - -\n"
                + "- - - - - - - -\n" + "- - - - - - - -\n"
                + "- - - - - - 3 -\n" + "- - - - - - 3 -\n"
                + "- - - - - - 3 -\n" + "- - - - - - - -\n";
        assertEquals(exp, board.toString(), "Board without ships or hits");
    }


}