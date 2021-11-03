import model.enums.HeroType;
import model.Marcos;
import model.enums.ItemsType;
import model.Luis;

import model.items.HoneySyrup;
import model.items.Star;
import model.items.redMushroom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {
    private Marcos testMarcos;
    private Luis testLuis;
    private Luis testLuisFull;
    private Marcos testMarcosFull;
    private Star testStar;
    private HoneySyrup testHoney;
    private redMushroom testMush;

    @BeforeEach
    public void setUp() {
        testMarcos = new Marcos(1, 5, 5, 5, 5, HeroType.MARCOS);
        testLuis = new Luis(1, 5, 5, 5, 5, HeroType.LUIS);
        testMarcosFull = new Marcos(4, HeroType.MARCOS);
        testLuisFull = new Luis(4, HeroType.LUIS);
        testStar = new Star();
        testHoney = new HoneySyrup();
        testMush = new redMushroom();
    }

    @Test
    public void constructorTest() {
        assertEquals(HeroType.MARCOS, testMarcos.getType());
        assertEquals(HeroType.LUIS, testLuis.getType());
        assertEquals(HeroType.MARCOS, testMarcosFull.getType());
        assertEquals(HeroType.LUIS, testLuisFull.getType());

        assertEquals(ItemsType.STAR, testStar.getType());
        assertEquals(ItemsType.HONEY_SYRUP, testHoney.getType());
        assertEquals(ItemsType.RED_MUSHROOM, testMush.getType());

    }

    @Test
    public void lvlUpLuisTest1() {
        int hpl = testLuisFull.getHitPoints();
        int dpl = testLuisFull.getDefPoints();
        testLuisFull.lvlUp(); // lvl 4 --> lvl 5
        assertEquals(hpl, testLuisFull.getHitPoints() - testLuisFull.update(hpl, 0.15));
        assertEquals(dpl, testLuisFull.getDefPoints() - testLuisFull.update(dpl, 0.15));
    }

    @Test
    public void lvlUpLuisTest2() {
        int hpl = testLuisFull.getHealthPoints();
        int fpl = testLuisFull.getFightPoint();
        testLuisFull.lvlUp();
        assertEquals(hpl, testLuisFull.getHealthPoints() - testLuisFull.updateHealth(testLuisFull.getRank(), 0.15));
        assertEquals(fpl, testLuisFull.getFightPoint() - testLuisFull.updateFight(testLuisFull.getRank(), 0.15));
    }

    @Test
    public void lvlUpMarcosTest1() {
        int hit = testMarcosFull.getHitPoints();
        int defense = testMarcosFull.getDefPoints();
        testMarcosFull.lvlUp(); //luis lvl.2
        assertEquals(defense + testMarcosFull.update(defense, 0.15), testMarcosFull.getDefPoints());
        assertEquals(hit + testMarcosFull.update(hit, 0.15), testMarcosFull.getHitPoints());

    }

    @Test
    public void lvlUpMarcosTest2() {
        int fight = testMarcosFull.getFightPoint();
        int health = testMarcosFull.getHealthPoints();
        testMarcosFull.lvlUp(); //luis lvl.2
        assertEquals(fight + testMarcosFull.updateFight(testMarcosFull.getRank(), 0.15), testMarcosFull.getFightPoint());
        assertEquals(health + testMarcosFull.updateHealth(testMarcosFull.getRank(), 0.15), testMarcosFull.getHealthPoints());
    }

    @Test
    public void addItemsTest() {
        testMarcos.addItem(testStar);
        assertNotEquals(testMarcos.getItemIndex(testStar), -1);
        testMarcos.addItem(testHoney);
        assertNotEquals(testMarcos.getItemIndex(testHoney), -1);
    }

    @Test
    public void HeroSpendItemTest() {
        testMarcos.addItem(testStar);
        testMarcos.SpendItem(testStar);
        assertTrue(testMarcos.getWeapons().isEmpty());
    }

    @Test
    public void maxHealthTest() {
        testMarcos.setHealthPoint(9); //max_healthPoints = 10
        int hpm = testMarcos.getHealthPoints();
        testMarcos.addItem(testMush);
        testMarcos.SpendItem(testMush); // +1
        assertEquals(testMarcos.getHealthPoints(),hpm + (int) (0.10* testMarcos.maxHealth()));
        testMarcos.addItem((testMush));
        testMarcos.SpendItem(testMush); // +1
        assertEquals(testMarcos.getHealthPoints(), testMarcos.maxHealth());
    }

    @Test
    public void maxFightTest() {
        testMarcos.addItem(testHoney);
        int fpm = testMarcos.getFightPoint();
        testMarcos.SpendItem(testHoney);

        assertEquals(testMarcos.getFightPoint(), fpm + 3);

        testMarcos.addItem(testHoney);
        testMarcos.SpendItem(testHoney);
        assertEquals(testMarcos.getFightPoint(), testMarcos.maxFight());
    }

    @Test
    public void updateMaxStatsLuisTest() {
        testLuis.maxLvlUp(3); //luis lvl.4
        assertEquals(testLuis.getHitPoints(), testLuisFull.getHitPoints());
        assertEquals(testLuis.getDefPoints(), testLuisFull.getDefPoints());
        assertEquals(testLuis.getHealthPoints(), testLuisFull.getHealthPoints());
        assertEquals(testLuis.getFightPoint(), testLuisFull.getFightPoint());
    }

    @Test
    public void defeatedTest() {
        //hero receives damage
        testMarcos.setHealthPoint(0);
        assertTrue(testMarcos.cDefeated());
    }

    @Test
    public void KoTest() {
        testLuis.setHealthPoint(0);
        testLuis.KO(testLuis);
        assertEquals(testLuis.getHitPoints(), 0);
    }
}

