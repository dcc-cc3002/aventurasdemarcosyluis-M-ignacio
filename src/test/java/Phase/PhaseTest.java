package Phase;

import controller.GameController;
import model.*;
import model.enums.HeroType;
import model.enums.ItemsType;
import model.interfaces.Character;
import model.interfaces.IItems;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import phases.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhaseTest {

    private GameController controller;
    private int seed;
    private int notSeed;
    private Marcos testMarcos;
    private Luis testLuis;
    private Chest testChest;
    private IItems testMush;
    private IItems testHoney;
    private Boo testBoo;
    private Goomba testGoomba;
    private Spiny testSpiny;
    private Phase primitivePhase;

    private Character player;


    @BeforeEach
    public void setUp() {
        seed = -9281;
        notSeed = 109281;
        primitivePhase = new Phase();
        controller = new GameController();
        testMarcos = (Marcos) controller.createHero(1, HeroType.MARCOS);
        testLuis = (Luis) controller.createHero(1, HeroType.LUIS); //+1
        controller.factoryPlantSeed(notSeed);
        testBoo = (Boo) controller.addEnemies(1); //+1
        testGoomba = (Goomba) controller.addEnemies(1);//+1
        testSpiny = (Spiny) controller.addEnemies(1);//+1
        testMush = controller.createItem(ItemsType.RED_MUSHROOM);
        testHoney = controller.createItem(ItemsType.HONEY_SYRUP);
        testChest = controller.addChest();
        controller.factoryPlantSeed(notSeed);
        player = controller.getIsPlaying();

    }

    @Test
    public void option2EndTurnTest() throws InvalidMovementException, InvalidSelectException {
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        assertEquals(player.getType(), HeroType.MARCOS);
        controller.readMovement(2); //2 terminar el turno
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.tryToEndTurn();
        assertEquals(controller.getActualPhase(), "EndTurnPhase");
    }

    @Test
    public void option1ItemUseTest() throws InvalidMovementException, InvalidSelectException {
        controller.addItem(testHoney);
        controller.addItem(testHoney);
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(1);
        assertEquals(controller.getActualPhase(), "WaitUseItemPhase");
        controller.readSelectItem(0);
        controller.readOptionItem(testMarcos);
        assertEquals(testChest.capacity(), 1); // se ocupo un item
        controller.tryToEndTurn(); // se termina el turno
        assertEquals(controller.getActualPhase(), "EndTurnPhase");
    }

    @Test
    public void option0AttackHeroHammerTest() throws InvalidMovementException, InvalidSelectException {
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(0);
        assertEquals(controller.getActualPhase(), "WaitBattlePhase");
        controller.selectEnemy(1); //Boo
        assertEquals(controller.getActualPhase(), "WaitBattlePhase");
        controller.tryToFightPhase();
        controller.tryToAttackHammer(seed); // Boo esquiva el ataque, -2 FightPoints
        assertEquals(testMarcos.getFightPoint(), 8);
        controller.tryToEndTurn();
        assertEquals(controller.getActualPhase(), "EndTurnPhase");
    }

    @Test
    public void option0AttackHeroJumpTest2() throws InvalidSelectException, InvalidMovementException, InvalidTransitionException {
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(0);
        assertEquals(controller.getActualPhase(), "WaitBattlePhase");
        controller.selectEnemy(1); //Goomba
        controller.tryToAttackJump();
        assertEquals(testMarcos.getFightPoint(), 9);
        controller.tryToEndTurn();
        assertEquals(controller.getActualPhase(), "EndTurnPhase");
    }

    @Test
    public void option0AttackHeroJumpTest3() throws InvalidSelectException, InvalidMovementException, InvalidTransitionException {
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(0);
        assertEquals(controller.getActualPhase(), "WaitBattlePhase");
        controller.selectEnemy(2); //Spiny
        controller.tryToAttackJump();
        assertEquals(testMarcos.getFightPoint(), 9);
        controller.tryToEndTurn();
        assertEquals(controller.getActualPhase(), "EndTurnPhase");
    }

    @Test
    public void errorAttackHeroTest() throws InvalidMovementException, InvalidSelectException {
        controller.finishTurn();
        assertEquals(controller.getActualPhase(), "StartPhase");
        assertEquals(controller.getIsPlaying().getType(), HeroType.LUIS);
        controller.playerHeroOrEnemy(seed); //se reconoce a un Hero, se mantiene en la fase de partida
        controller.readMovement(0); // se pasa a la configuración de batalla
        assertEquals(controller.getActualPhase(), "WaitBattlePhase");
        controller.selectEnemy(0); //Boo, enemigo no valido
        assertThrows(phases.InvalidSelectException.class,
                controller::tryToAttackJump); // no se puede seleccionar ese enemigo
    }

    @Test
    public void errorSelectItemTest() throws InvalidMovementException, InvalidSelectException {
        controller.getChest().add(testHoney);
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(1);
        assertEquals(controller.getActualPhase(), "WaitUseItemPhase");
        controller.readSelectItem(0);
    }

    @Test
    public void errorAttachEnemyTest() throws InvalidMovementException, InvalidSelectException {
        controller.finishTurn(); // turn Marcos finalizado
        controller.finishTurn(); // turno de Luis finalizado
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed); // se recnoce un oponente // se ataca automáticamente
        assertEquals(controller.getActualPhase(), "TurnEnemyPhase");
        controller.tryToEndTurn();
        assertEquals(controller.getActualPhase(), "EndTurnPhase");
    }

    @Test
    public void optionEnemyAttack() throws InvalidMovementException, InvalidSelectException {
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.finishTurn();
        controller.finishTurn();
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed); //turno del enemigo ataca a uno aleatorio
        assertEquals(controller.getActualPhase(), "TurnEnemyPhase");
        controller.tryToEndTurn();
        assertEquals(controller.getActualPhase(), "EndTurnPhase");
    }

    @Test
    public void AttackJumpOpponents() throws InvalidSelectException, InvalidTransitionException, InvalidMovementException {
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(0);
        assertEquals(controller.getActualPhase(), "WaitBattlePhase");
        controller.selectEnemy(0); //Spiny
        controller.tryToAttackJump();

        controller.tryToEndTurn();
        controller.tryStartTurn();
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(0);


        controller.selectEnemy(1);
        controller.tryToAttackJump();
        controller.tryToEndTurn();
        controller.tryStartTurn();
    }

    @Test
    public void luisAttackJumpOpponents() throws InvalidSelectException, InvalidTransitionException, InvalidMovementException {
        controller.finishTurn();
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(0);
        assertEquals(controller.getActualPhase(), "WaitBattlePhase");
        controller.selectEnemy(2); //Spiny
        controller.tryToAttackJump();

    }
    @Test
    public void OneGameTest() throws InvalidMovementException, InvalidSelectException, InvalidTransitionException {
        controller.fillChestInitial(3); //
        assertEquals(controller.getOrderOfPlayers().size(), 5); // dos heroes y 3 enemigos aleatorios
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(0); // atacar
        assertEquals(controller.getActualPhase(), "WaitBattlePhase");
        controller.selectEnemy(0); //Boo

        controller.tryToAttackJump();
        controller.tryToEndTurn();
        assertEquals(controller.getActualPhase(), "EndTurnPhase");

        //segundo turno
        controller.tryStartTurn();
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(0);
        controller.selectEnemy(1);
        controller.tryToFightPhase();
        controller.tryToAttackHammer(seed);
        controller.tryToEndTurn();
        assertEquals(controller.getActualPhase(), "EndTurnPhase");

        controller.tryStartTurn();
        controller.playerHeroOrEnemy(notSeed);
        assertEquals(controller.getActualPhase(), "TurnEnemyPhase");
        controller.tryToEndTurn();

        controller.tryStartTurn();
        controller.playerHeroOrEnemy(notSeed);
        assertEquals(controller.getActualPhase(), "TurnEnemyPhase");
        controller.tryToEndTurn();

        controller.tryStartTurn();
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(0);
        controller.selectEnemy(1);
        controller.tryToFightPhase();
        controller.tryToAttackHammer(seed);
        controller.tryToEndTurn();
        assertEquals(controller.getActualPhase(), "EndTurnPhase");

        controller.tryStartTurn();
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(0);
        controller.selectEnemy(2);
        controller.tryToFightPhase();
        controller.tryToAttackHammer(seed);
        controller.tryToEndTurn();
        assertEquals(controller.getActualPhase(), "EndTurnPhase");

        controller.tryStartTurn();
        controller.playerHeroOrEnemy(notSeed);
        assertEquals(controller.getActualPhase(), "TurnEnemyPhase");
        controller.tryToEndTurn();

        controller.tryStartTurn();
        controller.playerHeroOrEnemy(notSeed);
        assertEquals(controller.getActualPhase(), "TurnEnemyPhase");
        controller.tryToEndTurn();

        controller.tryStartTurn();
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(0);
        controller.selectEnemy(2);
        controller.tryToFightPhase();
        controller.tryToAttackHammer(seed);
        controller.tryToEndTurn();
        controller.finishTurn();
        controller.finishTurn();
        assertEquals(controller.getActualPhase(), "EndTurnPhase");

        controller.tryStartTurn();
        controller.playerHeroOrEnemy(notSeed);
        assertEquals(controller.getActualPhase(), "TurnEnemyPhase");
        controller.tryToEndTurn();

        controller.tryStartTurn();
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(0);
        controller.selectEnemy(0);
        controller.tryToFightPhase();
        controller.tryToAttackHammer(seed);
        controller.tryToEndTurn();

        controller.tryStartTurn();
        controller.playerHeroOrEnemy(notSeed);
        assertEquals(controller.getActualPhase(), "TurnEnemyPhase");
        controller.tryToEndTurn();

        controller.tryStartTurn();
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(0);
        controller.selectEnemy(0);
        controller.tryToAttackJump();
        controller.tryToEndTurn();
        controller.checkWinner();
        assertEquals(controller.getStateBattle(), 1);

        // se gana la batalla

        //se agregan +1Mushroom +1HoneySyrup
        controller.getChest().add(testMush);
        controller.getChest().add(testHoney);

        //tres enemigos aleatorios
        controller.addEnemies(2);
        controller.addEnemies(2);
        controller.addEnemies(2);

        // ambos personajes principales aumentan su nivel (1) -> (2)
        // si el personaje es derrota recupera un 15% de su salud
        controller.lvlUp();
        // Yaqui comenzará un nuevo nivel siguiendo la misma estructura de juego
    }

    @Test
    public void errorTransitionTest() {
        assertEquals(controller.getActualPhase(), "StartPhase");
        assertThrows(InvalidTransitionException.class, controller::tryToAttackJump);
    }

    @Test
    public void errorInvalidMovementExceptionTest() {
        assertEquals(controller.getActualPhase(), "StartPhase");
        assertThrows(phases.InvalidMovementException.class, controller.getPhase()::getOpponent);
    }

    @Test
    public void phaseTest() {
        assertEquals(controller.getActualPhase(), "StartPhase");
        assertThrows(phases.InvalidMovementException.class, () -> controller.getPhase().attackHero(controller.getPlayers().get(0)),
                "No se puede atacar un hero desde la etapa " + this.toString());
    }

    @Test
    public void phaseTest2(){
        assertEquals(controller.getActualPhase(), "StartPhase");
        assertThrows(phases.InvalidMovementException.class, () -> controller.getPhase().selectRandomHero(seed),
                "No se puede seleccionar a un hero en la etapa " + this.toString());
    }

    @Test
    public void phaseTest3(){
        assertEquals(controller.getActualPhase(), "StartPhase");
        assertThrows(phases.InvalidSelectException.class, () -> controller.getPhase().selectEnemy(1));
    }

    @Test
    public void phaseTest4(){
        assertEquals(controller.getActualPhase(), "StartPhase");
        assertThrows(phases.InvalidMovementException.class, () -> controller.getPhase().generateAttackJump(1));
    }

    @Test
    public void phaseTest5(){
        assertEquals(controller.getActualPhase(), "StartPhase");
        assertThrows(phases.InvalidMovementException.class, () -> controller.getPhase().generateAttackHammer(seed,1));
    }

    @Test
    public void phaseTest6(){
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.tryToWaitBattle();
        assertThrows(phases.InvalidMovementException.class,controller.getPhase()::endTurn);
    }

    @Test
    public void phaseTest7(){
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.tryToWaitBattle();
        assertThrows(phases.InvalidTransitionException.class,controller.getPhase()::toWaitUseItemPhase,
                "You can't move from " + this.toString() + " WaitUseItem Phase");
    }

    @Test
    public void phaseTest8(){
        assertEquals(controller.getActualPhase(), "StartPhase");
        assertThrows(phases.InvalidTransitionException.class, primitivePhase::toStartPhase);
    }

    @Test
    public void phaseTest9(){
        assertThrows(phases.InvalidTransitionException.class, primitivePhase::toTurnEnemy);
    }

    @Test
    public void notReadMovementTest() throws InvalidMovementException, InvalidSelectException {
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(3);
        assertEquals(controller.getActualPhase(), "StartPhase");
    }
    @Test
    public void notOptionItemTest() throws InvalidMovementException, InvalidSelectException {
        controller.addItem(testHoney);
        controller.addItem(testMush);
        assertEquals(controller.getActualPhase(), "StartPhase");
        controller.playerHeroOrEnemy(seed);
        controller.readMovement(1);
        assertEquals(controller.getActualPhase(), "WaitUseItemPhase");
        controller.readSelectItem(2);
        controller.readOptionItem(testMarcos);
        assertEquals(testChest.capacity(), 1); // se ocupo un item
        controller.tryToEndTurn(); // se termina el turno
    }

}
