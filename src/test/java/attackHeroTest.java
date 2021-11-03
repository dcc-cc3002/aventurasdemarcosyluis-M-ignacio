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
        int hp = testGoomba.getHealthPoints();
        int fp = testLuis.getFightPoint();

        int damage = testLuis.calculateDamage(testLuis, testGoomba, 1);
        testLuis.attackJump(testGoomba);

        assertEquals(hp, testGoomba.getHealthPoints() + damage);
        assertEquals(fp, testLuis.getFightPoint() + 1);
    }

    @Test
    public void LuisHitsGoombaTest2() {
        int hp = testGoomba.getHealthPoints();
        int hpl = testLuis.getHealthPoints();
        int fp = testLuis.getFightPoint();

        int damage = testGoomba.calculateDamage(testLuis, testGoomba, 1.5);
        testLuis.attackHammer(testGoomba)
        ;
        assertEquals(hp, testGoomba.getHealthPoints() + damage);
        assertEquals(hpl, testLuis.getHealthPoints());
        assertEquals(fp, testLuis.getFightPoint() + 2);
    }

    @Test
    public void LuisHitsSpinyTest1() {
        int hps = testSpiny.getHealthPoints();
        int hpl = testLuis.getHealthPoints();
        int fp = testLuis.getFightPoint();
        int damage = testLuis.boundAttack(0.05);

        testLuis.attackJump(testSpiny);

        assertEquals(hps, testSpiny.getHealthPoints());
        assertEquals(hpl, testLuis.getHealthPoints() + damage);
        assertEquals(fp, testLuis.getFightPoint() + 1);
    }

    @Test
    public void LuisHitsSpinyTest2() {
        int hp = testSpiny.getHealthPoints();
        int hpm = testLuis.getHealthPoints();
        int fp = testLuis.getFightPoint();

        int damage = testSpiny.calculateDamage(testLuis, testSpiny, 1.5);
        testLuis.attackHammer(testSpiny);

        assertEquals(hp, testSpiny.getHealthPoints() + damage);
        assertEquals(hpm, testLuis.getHealthPoints());
        assertEquals(fp, testLuis.getFightPoint() + 2);
    }

    @Test
    public void MarcosHitsGoombaTest1() {
        int hp = testGoomba.getHealthPoints();
        int fp = testMarcos.getFightPoint();
        int damage = testMarcos.calculateDamage(testMarcos, testGoomba, 1);

        testMarcos.attackJump(testGoomba);

        assertEquals(hp, testGoomba.getHealthPoints() + damage);
        assertEquals(fp, testMarcos.getFightPoint() + 1);
    }
    @Test
    public void MarcosHitsGoombaTest2() {
        int hp = testGoomba.getHealthPoints();
        int hpm = testMarcos.getHealthPoints();
        int fp = testMarcos.getFightPoint();

        testMarcos.attackHammer(testGoomba);

        assertEquals(hp, testGoomba.getHealthPoints());
        assertEquals(hpm, testMarcos.getHealthPoints());
        assertEquals(fp, testMarcos.getFightPoint() + 2);
    }

    @Test
    public void MarcosHitsSpinyTest1() {
        int hp = testSpiny.getHealthPoints();
        int hpm = testMarcos.getHealthPoints();
        int fp = testMarcos.getFightPoint();

        int damage = testMarcos.boundAttack(0.05);
        testMarcos.attackJump(testSpiny);

        assertEquals(hp, testSpiny.getHealthPoints());
        assertEquals(hpm, testMarcos.getHealthPoints() + damage);
        assertEquals(fp, testMarcos.getFightPoint() + 1);
    }

    @Test
    public void MarcosHitsSpinyTest2() {
        int hps = testSpiny.getHealthPoints();
        int hpm = testMarcos.getHealthPoints();
        int fpm = testMarcos.getFightPoint();

        int damage = testSpiny.calculateDamage(testMarcos,testSpiny,1.5);
        testMarcos.attackHammer(testSpiny);

        assertEquals(hps, testSpiny.getHealthPoints()+damage);
        assertEquals(hpm, testMarcos.getHealthPoints());
        assertEquals(fpm, testMarcos.getFightPoint() + 2);
    }

    @Test
    public void MarcosHitsBooTest1() {
        int hp = testBoo.getHealthPoints();
        int fp = testMarcos.getFightPoint();
        int damage = testMarcos.calculateDamage(testMarcos, testBoo, 1);

        testMarcos.attackJump(testBoo);

        assertEquals(hp, testBoo.getHealthPoints() + damage);
        assertEquals(fp, testMarcos.getFightPoint() + 1);
    }

    @Test
    public void MarcosHitsBooTest2() {
        int hp = testBoo.getHealthPoints();
        int hpm = testMarcos.getHealthPoints();
        int fp = testMarcos.getFightPoint();

        testMarcos.attackHammer(testBoo);

        assertEquals(hp, testBoo.getHealthPoints());
        assertEquals(hpm, testMarcos.getHealthPoints());
        assertEquals(fp, testMarcos.getFightPoint() + 2);
    }
}
