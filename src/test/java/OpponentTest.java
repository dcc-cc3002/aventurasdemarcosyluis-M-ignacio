import model.OpponentType;
import model.Opponent;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class OpponentTest {
    private Opponent testGoomba;
    private Opponent testBoo;
    private Opponent testSpiny;
    private Opponent testGoombaFull;
    private Opponent testBooFull;
    private Opponent testSpinyFull;

    @BeforeEach
    public void setUp() {
        testGoomba = new Opponent(1, 5, 5, 5, OpponentType.GOOMBA);
        testBoo = new Opponent(1, 5, 5, 5, OpponentType.BOO);
        testSpiny = new Opponent(1, 5, 5, 5, OpponentType.SPINY);

        testGoombaFull = new Opponent(5, OpponentType.GOOMBA);
        testBooFull = new Opponent(5, OpponentType.BOO);
        testSpinyFull = new Opponent(5, OpponentType.SPINY);
    }

    @Test
    public void constructorTest() {
        assertEquals(OpponentType.GOOMBA, testGoomba.getType());
        assertEquals(OpponentType.BOO, testBoo.getType());
        assertEquals(OpponentType.SPINY, testSpiny.getType());

        assertEquals(OpponentType.GOOMBA, testGoombaFull.getType());
        assertEquals(OpponentType.BOO, testBooFull.getType());
        assertEquals(OpponentType.SPINY, testSpinyFull.getType());
    }

    @Test
    public void updateGoombaTest() {
        testGoomba.updateLvl(4);
        assertEquals(testGoomba.getHitPoints(), testGoombaFull.getHitPoints());
        assertEquals(testGoomba.getDefPoints(), testGoombaFull.getDefPoints());
        assertEquals(testGoomba.getHealthPoints(), testGoombaFull.getHealthPoints());
    }

    @Test
    public void updateBooTest() {
        testBoo.updateLvl(4);
        assertEquals(testBoo.getHitPoints(), testBooFull.getHitPoints());
        assertEquals(testBoo.getDefPoints(), testBooFull.getDefPoints());
        assertEquals(testBoo.getHealthPoints(), testBooFull.getHealthPoints());
    }

    @Test
    public void updateSpinyTest() {
        testSpiny.updateLvl(4);
        assertEquals(testSpiny.getHitPoints(), testSpinyFull.getHitPoints());
        assertEquals(testSpiny.getDefPoints(), testSpinyFull.getDefPoints());
        assertEquals(testSpiny.getHealthPoints(), testSpinyFull.getHealthPoints());
    }

    @Test
    public void defeatedTest(){
        //enemy receives attack and his health points set in zero.
        testSpiny.setHealthPoint(0);
        assertTrue(testSpiny.defeated(testSpiny));
        testSpiny.setHealthPoint(testSpiny.maxHealth());
        assertFalse(testSpiny.defeated(testSpiny));

    }

    @Test
    public void KoTest() {
        //enemy receives attack and his health points set in zero.
        testBoo.setHealthPoint(0);
        testBoo.KO(testBoo);
        assertEquals(testBoo.getHitPoints(), 0);
    }


}
