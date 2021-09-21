import model.HeroType;
import model.Hero;
import model.ItemsType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HeroTest {
    private Hero testMarcos;
    private  Hero testLuis;
    private Hero testHeroFull;
    private ItemsType testStar,testHoney, testMush;

    @BeforeEach
    public void setUp() {
        testMarcos = new Hero(1, 5, 5, 25,5, HeroType.MARCOS);
        testLuis = new Hero(1, 5, 5, 5,5, HeroType.LUIS);
        testHeroFull = new Hero(5,HeroType.LUIS, 5);
        testStar = ItemsType.STAR;
        testHoney = ItemsType.HONEY_SYRUP;
        testMush = ItemsType.RED_MUSHROOM;
    }

    @Test
    public void constructorTest1(){
        assertEquals(HeroType.MARCOS,testMarcos.getType());
        assertEquals(HeroType.LUIS,testLuis.getType());
        assertEquals(ItemsType.STAR,testStar);
        assertEquals(ItemsType.HONEY_SYRUP,testHoney);
        assertEquals(ItemsType.RED_MUSHROOM,testMush);
    }

    @Test
    public void HeroFullTest(){
        assertEquals(testHeroFull.getDefPoints(),40);
        assertEquals(testHeroFull.getHealthPoints(),30);
        assertEquals(testHeroFull.getFightPoints(),25);
        assertEquals(testHeroFull.getHitPoints(),50);
    }

    @Test
    public void addItemsTest(){
        testMarcos.addItem(testStar);
        assertNotEquals(testMarcos.getItemIndex(testStar),-1);
        testMarcos.addItem(testHoney);
        assertNotEquals(testMarcos.getItemIndex(testHoney),-1);
    }

    @Test
    public void HeroSpendItemTest(){
        testMarcos.addItem(testStar);
        testMarcos.SpendItem(testStar);
        assertTrue(testMarcos.getWeapons().isEmpty());
    }

    @Test
    public void maxHealthTest(){
        testMarcos.addItem(testMush);
        testMarcos.SpendItem(testMush);
        assertEquals(testMarcos.getHealthPoints(),28);
        //max health for lvl.
        testMarcos.addItem((testMush));
        testMarcos.SpendItem(testMush);
        assertEquals(testMarcos.getHealthPoints(),30);

    }

    @Test
    public void updateLvlTest(){
        testLuis.updateLvl(4); //luis lvl.5
        assertEquals(testLuis.getHitPoints(),testHeroFull.getHitPoints());
        assertEquals(testLuis.getHitPoints(),testHeroFull.getHitPoints());
        assertEquals(testLuis.getDefPoints(),testHeroFull.getDefPoints());
        assertEquals(testLuis.getHealthPoints(),testHeroFull.getHealthPoints());
    }

}

