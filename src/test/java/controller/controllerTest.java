package controller;

import model.*;
import model.enums.HeroType;
import model.enums.ItemsType;
import model.enums.OpponentType;
import model.interfaces.*;
import model.interfaces.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

public class controllerTest {
    private GameController controller;
    private ArrayList<Character> testOrderOfPlayers;
    private Marcos testMarcos;
    private Luis testLuis;
    private Chest testChest;
    private Goomba testGoomba;
    private Spiny testSpiny;
    private Boo testBoo;
    private IItems testMush;
    private IItems testHoney;
    private int seed2;
    private int seed;

    @BeforeEach
    public void setUp() {
        seed2 = -9281;
        seed = 109281;
        controller = new GameController();
        testMarcos = (Marcos) controller.createHero(1, HeroType.MARCOS); //+1
        testLuis = (Luis) controller.createHero(1, HeroType.LUIS); //+1
        testChest = controller.addChest();
        controller.factoryPlantSeed(seed);
        testBoo = (Boo) controller.addEnemies(1); //+1
        testGoomba = (Goomba) controller.addEnemies(1);//+1
        testSpiny = (Spiny) controller.addEnemies(1);//+1
        testMush = controller.createItem(ItemsType.RED_MUSHROOM);
        testHoney = controller.createItem(ItemsType.HONEY_SYRUP);
    }

    @Test
    public void createCharacterTest() {
        assertEquals(testMarcos.getType(), HeroType.MARCOS);
        assertEquals(testLuis.getType(), HeroType.LUIS);
        assertEquals(testGoomba.getType(), OpponentType.GOOMBA);
        assertEquals(testSpiny.getType(), OpponentType.SPINY);
        assertEquals(testBoo.getType(), OpponentType.BOO);
    }

    @Test
    public void fillChestLvl1Test() {
        controller.fillChestInitial(testChest, 3);
        assertEquals(testChest.getValue(testMush.getType()), 3);
        assertEquals(testChest.getValue(testHoney.getType()), 3);
    }

    @Test
    public void fillChestOtherLvlTest(){
        controller.addItem(testChest,testMush);
        controller.addItem(testChest,testHoney);
        assertEquals(testChest.getValue(ItemsType.RED_MUSHROOM),1);
        assertEquals(testChest.getValue(ItemsType.HONEY_SYRUP),1);
    }
    @Test
    public void SpendItemTest() {
        controller.addItem(testChest, testHoney);
        int fpm = testMarcos.getFightPoint() - 3;
        testMarcos.setFightPoint(fpm);
        testChest.spend(testHoney, testMarcos);
        assertEquals(testChest.capacity(), 0);
        assertEquals(fpm, testMarcos.getFightPoint() - 3);
    }

    @Test
    public void getAllItemChest(){
        Hashtable<ItemsType, Integer> n = controller.getItem(testChest);
        assertEquals(n,testChest.getItemsChest());
    }

    @Test
    public void getAllPlayerTest(){
        ArrayList<Character> n = controller.getOrderOfPlayers();
        assertEquals(n.size(),5);

        assertEquals(n.get(0),testMarcos);
        assertEquals(n.get(1),testLuis);
        assertEquals(n.get(2),testBoo);
        assertEquals(n.get(3),testGoomba);
        assertEquals(n.get(4),testSpiny);
    }

    @Test
    public void defeatedEnemyTest(){
        testMarcos.attackJump(testSpiny);
        testSpiny.setHealthPoint(0); // se supone iterar el ataque hasta hacer sus punto de vida 0
        controller.defeatedCharacter(testSpiny);
        assertFalse(controller.existCharacter(testSpiny));
    }

    @Test
    public void selectPlayerTest() {
        controller.actualPlayer();
        assertEquals(controller.getIsPlaying(), testMarcos);
        controller.nextPlayer();
        assertEquals(controller.getIsNextPlayer(), testLuis);
    }

    @Test
    public void finishTurnTest(){
        controller.actualPlayer();
        assertEquals(controller.getIsPlaying(),testMarcos);
        controller.finishTurn();
        assertEquals(controller.getIsPlaying(),testLuis);
        controller.finishTurn();
        assertEquals(controller.getIsPlaying(),testBoo);
    }

    @Test
    public void completeTurnRoundTest(){
        controller.actualPlayer();
        assertEquals(controller.getIsPlaying(),testMarcos);
        controller.finishTurn(); //end turn marcos
        controller.finishTurn(); //end turn Luis
        controller.finishTurn(); //end turn Boo
        controller.finishTurn(); // end turn goomba
        assertEquals(controller.getIsPlaying(),testSpiny);
        controller.finishTurn();

        assertEquals(controller.getIsPlaying(),testMarcos); // se vuelve al primero. cierra el ciclo.
    }

    @Test
    public void win(){
        controller.checkWinner();
        assertEquals(controller.getStateBattle(),0);
        controller.knifeInWindpipe(testSpiny);
        controller.knifeInWindpipe(testBoo);
        controller.knifeInWindpipe(testGoomba);
        assertEquals(controller.getStateBattle(),1);
    }

    @Test
    public void loose(){
        controller.checkWinner();
        assertEquals(controller.getStateBattle(),0);
        controller.knifeInWindpipe(testMarcos);
        controller.knifeInWindpipe(testLuis);
        assertEquals(controller.getStateBattle(),-1);
    }

    @Test
    public void executeBattle1Test(){
        controller.actualPlayer();
        controller.nextPlayer();
        testMarcos.attackHammer(testGoomba, seed2);
        controller.finishTurn();

        assertEquals(controller.getIsPlaying(),testLuis);
        testLuis.attackHammer(testGoomba, seed2);
        controller.defeatedCharacter(testGoomba);
        controller.finishTurn();

        assertEquals(controller.getIsPlaying(),testBoo);
        testBoo.attackNormal(testLuis);
        controller.defeatedCharacter(testLuis);
        controller.finishTurn();

        assertEquals(controller.getIsPlaying(),testSpiny);
        testSpiny.attackNormal(testMarcos);
        controller.finishTurn();

        assertEquals(controller.getStateBattle(),0);
    }



}
