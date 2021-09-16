import model.HeroType;
import model.Hero;
import model.Items;
import model.ItemsType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HeroTest {
    private Hero testMarcos;
    private  Hero testLuis;
    private ItemsType testStar,testHoney, testMush;

    @BeforeEach
    public void setUp() {
        testMarcos = new Hero(1, 5, 5, 20, HeroType.MARCOS);
        testLuis = new Hero(1, 5, 5, 20, HeroType.LUIS);
        testStar = ItemsType.STAR;
        testHoney = ItemsType.HONEY_SYRUP;
        testMush = ItemsType.RED_MUSHROOM;
    }

    @Test
    public void constructorTest(){
        assertEquals(HeroType.MARCOS,testMarcos.getType());
        assertEquals(HeroType.LUIS,testLuis.getType());
        assertEquals(ItemsType.STAR,testStar);
        assertEquals(ItemsType.HONEY_SYRUP,testHoney);
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
        testMarcos.SpendItemTest(testStar);
        assertTrue(testMarcos.getWeapons().isEmpty());

    }

    @Test
    public void maxHealthTest(){
        testMarcos.addItem(testMush);
        testMarcos.SpendItemTest(testMush);
        assertEquals(testMarcos.getHealthPoint(),23);
    }

}

