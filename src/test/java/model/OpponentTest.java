package model;

import model.*;
import model.enums.OpponentType;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class OpponentTest {

    private Goomba testGoomba;
    private Boo testBoo;
    private Spiny testSpiny;
    private Goomba testGoombaFull;
    private Boo testBooFull;
    private Spiny testSpinyFull;


    @BeforeEach
    public void setUp() {
        testGoomba = new Goomba(1, 5, 5, 5, OpponentType.GOOMBA);
        testBoo = new Boo(1, 5, 5, 5, OpponentType.BOO);
        testSpiny = new Spiny(1, 5, 5, 5, OpponentType.SPINY);

        testGoombaFull = new Goomba(5, OpponentType.GOOMBA);
        testBooFull = new Boo(5, OpponentType.BOO);
        testSpinyFull = new Spiny(5, OpponentType.SPINY);
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
        testGoomba.maxLvlUp(4);
        assertEquals(testGoomba.getHitPoints(), testGoombaFull.getHitPoints());
        assertEquals(testGoomba.getDefPoints(), testGoombaFull.getDefPoints());
        assertEquals(testGoomba.getHealthPoints(), testGoombaFull.getHealthPoints());
    }

    @Test
    public void updateBooTest() {
        testBoo.maxLvlUp(4);
        assertEquals(testBoo.getHitPoints(), testBooFull.getHitPoints());
        assertEquals(testBoo.getDefPoints(), testBooFull.getDefPoints());
        assertEquals(testBoo.getHealthPoints(), testBooFull.getHealthPoints());
    }

    @Test
    public void updateSpinyTest() {
        testSpiny.maxLvlUp(4);
        assertEquals(testSpiny.getHitPoints(), testSpinyFull.getHitPoints());
        assertEquals(testSpiny.getDefPoints(), testSpinyFull.getDefPoints());
        assertEquals(testSpiny.getHealthPoints(), testSpinyFull.getHealthPoints());
    }

    @Test
    public void defeatedTest(){
        //enemy receives attack and his health points set in zero.
        testSpiny.setHealthPoint(0);
        assertTrue(testSpiny.cDefeated());
        testSpiny.setHealthPoint(testSpiny.maxHealth());
        assertFalse(testSpiny.cDefeated());

    }

    @Test
    public void KoTest() {
        //enemy receives attack and his health points set in zero.
        testBoo.setHealthPoint(0);
        testBoo.KO();
        assertEquals(testBoo.getHitPoints(), 0);
    }


}
