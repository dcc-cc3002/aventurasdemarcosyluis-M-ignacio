import model.HeroType;
import model.Hero;
import model.ItemsType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {
    private Hero testMarcos;
    private Hero testLuis;
    private Hero testLuisFull;
    private Hero testMarcosFull;
    private ItemsType testStar, testHoney, testMush;

    @BeforeEach
    public void setUp() {
        testMarcos = new Hero(1, 5, 5, 25, 5, HeroType.MARCOS);
        testLuis = new Hero(1, 5, 5, 25, 5, HeroType.LUIS);
        testMarcosFull = new Hero(5, HeroType.MARCOS, 5);
        testLuisFull = new Hero(5, HeroType.LUIS, 5);
        testStar = ItemsType.STAR;
        testHoney = ItemsType.HONEY_SYRUP;
        testMush = ItemsType.RED_MUSHROOM;
    }

    @Test
    public void constructorTest() {
        assertEquals(HeroType.MARCOS, testMarcos.getType());
        assertEquals(HeroType.LUIS, testLuis.getType());
        assertEquals(HeroType.MARCOS, testMarcosFull.getType());
        assertEquals(HeroType.LUIS, testLuisFull.getType());

        assertEquals(ItemsType.STAR, testStar);
        assertEquals(ItemsType.HONEY_SYRUP, testHoney);
        assertEquals(ItemsType.RED_MUSHROOM, testMush);

    }

    @Test
    public void HeroFullTest() {
        assertEquals(testLuisFull.getHitPoints(), 50);
        assertEquals(testLuisFull.getDefPoints(), 40);
        assertEquals(testLuisFull.getHealthPoints(), 30);
        assertEquals(testLuisFull.getFightPoints(), 25);
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
        testMarcos.addItem(testMush);
        testMarcos.SpendItem(testMush);
        assertEquals(testMarcos.getHealthPoints(), 28);
        //max health for lvl.
        testMarcos.addItem((testMush));
        testMarcos.SpendItem(testMush);
        assertEquals(testMarcos.getHealthPoints(), testMarcos.maxHealthGeneric());
    }

    @Test
    public void maxFightTest() {
        testMarcos.addItem(testHoney);
        testMarcos.SpendItem(testHoney);
        assertEquals(testMarcos.getFightPoints(), 8);

        testMarcos.addItem(testHoney);
        testMarcos.SpendItem(testHoney);
        assertEquals(testMarcos.getFightPoints(), testMarcos.maxFight());
    }

    @Test
    public void updateLvlLuisTest() {
        testLuis.updateLvl(4); //luis lvl.5
        assertEquals(testLuis.getHitPoints(), testLuisFull.getHitPoints());
        assertEquals(testLuis.getDefPoints(), testLuisFull.getDefPoints());
        assertEquals(testLuis.getHealthPoints(), testLuisFull.getHealthPoints());
        assertEquals(testLuis.getFightPoints(), testLuisFull.getFightPoints());
    }

    @Test
    public void updateLvlMarcosTest() {
        testMarcos.updateLvl(4); //luis lvl.5
        assertEquals(testMarcos.getHitPoints(), testMarcosFull.getHitPoints());
        assertEquals(testMarcos.getDefPoints(), testMarcosFull.getDefPoints());
        assertEquals(testMarcos.getHealthPoints(), testMarcosFull.getHealthPoints());
        assertEquals(testMarcos.getFightPoints(), testMarcosFull.getFightPoints());
    }

    @Test
    public void defeatedTest() {
        //hero receives damage
        testMarcos.setHealthPoint(0);
        assertTrue(testMarcos.defeated(testMarcos));
    }

    @Test
    public void KoTest() {
        testLuis.setHealthPoint(0);
        testLuis.KO(testLuis);
        assertEquals(testLuis.getHitPoints(), 0);
    }
}

