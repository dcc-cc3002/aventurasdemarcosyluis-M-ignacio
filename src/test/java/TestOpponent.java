import model.OpponentType;
import model.Opponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestOpponent {
    private Opponent testGoomba;
    private Opponent testBoo;
    private Opponent testSpiny;

    @BeforeEach
    public void setUp(){
    testGoomba = new Opponent(10,3,10,20,OpponentType.GOOMBA);
    testBoo = new Opponent(10,3,10,20,OpponentType.BOO);
    testSpiny = new Opponent(10,3,10,20,OpponentType.SPINY);
    }

    @Test
    public void constructorTest(){
        assertEquals(OpponentType.GOOMBA,testGoomba.getType());
        assertEquals(OpponentType.BOO,testBoo.getType());
        assertEquals(OpponentType.SPINY,testSpiny.getType());
    }

}
