package model;

import model.*;
import model.enums.HeroType;
import model.enums.OpponentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class attackHeroTest {
    private Marcos testMarcos;
    private Luis testLuis;
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
    public void LuisHitsGoombaTest1() {
        int hpg = testGoomba.getHealthPoints();
        int fpl = testLuis.getFightPoint();

        int damage = testLuis.calculateDamage(testLuis, testGoomba, 1);
        testLuis.attackJump(testGoomba);

        assertEquals(hpg, testGoomba.getHealthPoints() + damage);
        assertEquals(fpl, testLuis.getFightPoint() + 1);
    }

    @Test
    public void LuisHitsGoombaTest2() {
        int hp = testGoomba.getHealthPoints();
        int hpl = testLuis.getHealthPoints();
        int fp = testLuis.getFightPoint();

        int damage = testGoomba.calculateDamage(testLuis, testGoomba, 1.5);
        testLuis.attackHammer(testGoomba, -9281);

        assertEquals(hp, testGoomba.getHealthPoints() + damage);
        assertEquals(hpl, testLuis.getHealthPoints());
        assertEquals(fp, testLuis.getFightPoint() + 2);
    }

    @Test
    public void LuisHitsSpinyTest1() {
        int hps = testSpiny.getHealthPoints();
        int hpl = testLuis.getHealthPoints();
        int fpl = testLuis.getFightPoint();

        int damage = testLuis.boundAttack(0.05);
        testLuis.attackJump(testSpiny);

        assertEquals(hps, testSpiny.getHealthPoints());
        assertEquals(hpl, testLuis.getHealthPoints() + damage);
        assertEquals(fpl, testLuis.getFightPoint() + 1);
    }

    @Test
    public void LuisHitsSpinyTest2() {
        int hps = testSpiny.getHealthPoints();
        int hpl = testLuis.getHealthPoints();
        int fpl = testLuis.getFightPoint();

        int damage = testSpiny.calculateDamage(testLuis, testSpiny, 1.5);
        testLuis.attackHammer(testSpiny, -9281);

        assertEquals(hps, testSpiny.getHealthPoints() + damage);
        assertEquals(hpl, testLuis.getHealthPoints());
        assertEquals(fpl, testLuis.getFightPoint() + 2);
    }

    @Test
    public void MarcosHitsGoombaTest1() {
        int hpg = testGoomba.getHealthPoints();
        int fpm = testMarcos.getFightPoint();

        int damage = testMarcos.calculateDamage(testMarcos, testGoomba, 1);
        testMarcos.attackJump(testGoomba);

        assertEquals(hpg, testGoomba.getHealthPoints() + damage);
        assertEquals(fpm, testMarcos.getFightPoint() + 1);
    }

    @Test
    public void MarcosHitsGoombaTest2() {
        int hpg = testGoomba.getHealthPoints();
        int hpm = testMarcos.getHealthPoints();
        int fpm = testMarcos.getFightPoint();

        int damage = testMarcos.calculateDamage(testMarcos, testGoomba, 1.5);
        testMarcos.attackHammer(testGoomba, -9281);

        assertEquals(hpg, testGoomba.getHealthPoints() + damage);
        assertEquals(hpm, testMarcos.getHealthPoints());
        assertEquals(fpm, testMarcos.getFightPoint() + 2);
    }

    @Test
    public void MarcosHitsSpinyTest1() {
        int hps = testSpiny.getHealthPoints();
        int hpm = testMarcos.getHealthPoints();
        int fpm = testMarcos.getFightPoint();

        int damage = testMarcos.boundAttack(0.05);
        testMarcos.attackJump(testSpiny);

        assertEquals(hps, testSpiny.getHealthPoints());
        assertEquals(hpm, testMarcos.getHealthPoints() + damage);
        assertEquals(fpm, testMarcos.getFightPoint() + 1);
    }

    @Test
    public void MarcosHitsSpinyTest2() {
        int hps = testSpiny.getHealthPoints();
        int hpm = testMarcos.getHealthPoints();
        int fpm = testMarcos.getFightPoint();

        int damage = testSpiny.calculateDamage(testMarcos, testSpiny, 1.5);
        testMarcos.attackHammer(testSpiny, -9281);

        assertEquals(hps, testSpiny.getHealthPoints() + damage);
        assertEquals(hpm, testMarcos.getHealthPoints());
        assertEquals(fpm, testMarcos.getFightPoint() + 2);
    }

    @Test
    public void MarcosHitsBooTest1() {
        int hpb = testBoo.getHealthPoints();
        int fpm = testMarcos.getFightPoint();
        int damage = testMarcos.calculateDamage(testMarcos, testBoo, 1);

        testMarcos.attackJump(testBoo);

        assertEquals(hpb, testBoo.getHealthPoints() + damage);
        assertEquals(fpm, testMarcos.getFightPoint() + 1);
    }

    @Test
    public void MarcosHitsBooTest2() {
        int hpb = testBoo.getHealthPoints();
        int fpm = testMarcos.getFightPoint();
        testMarcos.attackHammer(testBoo, -9281);
        assertEquals(hpb, testBoo.getHealthPoints());
        assertEquals(fpm, testMarcos.getFightPoint() + 2);
    }

    @Test
    public void LuisNotHitGoombaTest2() {
        int hpg = testGoomba.getHealthPoints();
        int fpl = testLuis.getFightPoint();
        testLuis.attackHammer(testGoomba, 59949281);
        assertEquals(hpg, testGoomba.getHealthPoints());
        assertEquals(fpl, testLuis.getFightPoint() + 2);
    }

    @Test
    public void LuisNotHitsSpinyTest2() {
        int hps = testSpiny.getHealthPoints();
        int fpl = testLuis.getFightPoint();
        testLuis.attackHammer(testSpiny, 59949281);
        assertEquals(hps, testSpiny.getHealthPoints());
        assertEquals(fpl, testLuis.getFightPoint() + 2);
    }

    @Test
    public void MarcosNotHitsGoombaTest2() {
        int hpg = testGoomba.getHealthPoints();
        int fpm = testMarcos.getFightPoint();
        testMarcos.attackHammer(testGoomba, 59949281);
        assertEquals(hpg, testGoomba.getHealthPoints());
        assertEquals(fpm, testMarcos.getFightPoint() + 2);
    }

    @Test
    public void MarcosNotHitsSpinyTest2() {
        int hps = testSpiny.getHealthPoints();
        int fpm = testMarcos.getFightPoint();
        testMarcos.attackHammer(testSpiny, 59949281);
        assertEquals(hps, testSpiny.getHealthPoints());
        assertEquals(fpm, testMarcos.getFightPoint() + 2);
    }

    @Test
    public void MarcosNotHitsBooTest2() {
        int hpb = testBoo.getHealthPoints();
        int fpm = testMarcos.getFightPoint();
        testMarcos.attackHammer(testBoo, 59949281);
        assertEquals(hpb, testBoo.getHealthPoints());
        assertEquals(fpm, testMarcos.getFightPoint() + 2);
    }
}
