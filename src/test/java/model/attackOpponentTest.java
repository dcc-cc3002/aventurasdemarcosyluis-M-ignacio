package model;

import model.*;
import model.enums.HeroType;
import model.enums.OpponentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class attackOpponentTest {
    private Luis testLuis;
    private Marcos testMarcos;
    private Goomba testGoomba;
    private Spiny testSpiny;
    private Boo testBoo;

    @BeforeEach
    public void setUp() {
        testLuis = new Luis(1, HeroType.LUIS);
        testMarcos = new Marcos(1, HeroType.MARCOS);
        testGoomba = new Goomba(1, OpponentType.GOOMBA);
        testBoo = new Boo(1, OpponentType.BOO);
        testSpiny = new Spiny(1, OpponentType.SPINY);
    }

    @Test
    public void goombaHitsMarcosTest() {
        int hpm = testMarcos.getHealthPoints();
        int hpg = testGoomba.getHealthPoints();
        int damage = testGoomba.calculateDamage(testGoomba, testMarcos, 0.75);

        testGoomba.attackNormal(testMarcos);

        assertEquals(hpm, testMarcos.getHealthPoints() + damage);
        assertEquals(hpg, testGoomba.getHealthPoints());
    }

    @Test
    public void goombaHitsLuisTest() {
        int hpl = testLuis.getHealthPoints();
        int hpg = testGoomba.getHealthPoints();
        int damage = testGoomba.calculateDamage(testGoomba, testLuis, 0.75);

        testGoomba.attackNormal(testLuis);

        assertEquals(hpl, testLuis.getHealthPoints() + damage);
        assertEquals(hpg, testGoomba.getHealthPoints());
    }

    @Test
    public void spinyHitsMarcosTest() {
        int hpm = testMarcos.getHealthPoints();
        int hps = testSpiny.getHealthPoints();
        int damage = testSpiny.calculateDamage(testSpiny, testMarcos, 0.75);

        testSpiny.attackNormal(testMarcos);

        assertEquals(hpm, testMarcos.getHealthPoints() + damage);
        assertEquals(hps, testSpiny.getHealthPoints());
    }

    @Test
    public void spinyHitsLuisTest() {
        int hpl = testLuis.getHealthPoints();
        int hps = testSpiny.getHealthPoints();
        int damage = testSpiny.calculateDamage(testSpiny, testLuis, 0.75);

        testSpiny.attackNormal(testLuis);

        assertEquals(hpl, testLuis.getHealthPoints() + damage);
        assertEquals(hps, testSpiny.getHealthPoints());
    }

    @Test
    public void booHitsLuisTest() {
        int hpl = testLuis.getHealthPoints();
        int hpb = testBoo.getHealthPoints();
        int damage = testBoo.calculateDamage(testBoo, testLuis, 0.75);

        testBoo.attackNormal(testLuis);
        assertEquals(hpl, testLuis.getHealthPoints() + damage);
        assertEquals(hpb, testBoo.getHealthPoints());
    }
}
