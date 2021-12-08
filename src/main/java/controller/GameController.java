package controller;

import model.*;
import model.enums.HeroType;
import model.enums.ItemsType;
import model.factory.OpponentRandomFactory;
import model.interfaces.*;
import model.interfaces.Character;
import model.items.HoneySyrup;
import model.items.RedMushroom;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.ListIterator;

/**
 * the controller acts as an intermediary between the objects
 * of the model and the graphical interface of the application.
 */
public class GameController {
    private final ArrayList<Character> orderOfPlayers;
    int turn;
    private Character isPlaying;
    private Character isNextPlayer;
    private final OpponentRandomFactory factory;
    private int stateBattle;

    public Chest getSharedChest() {
        return sharedChest;
    }

    public void setSharedChest(Chest sharedChest) {
        this.sharedChest = sharedChest;
    }

    private Chest sharedChest;

    /**
     * Controller constructor. Allows you to use the methods to use
     * with the functionality of the model.
     */
    public GameController() {
        orderOfPlayers = new ArrayList<>();
        factory = new OpponentRandomFactory();
        turn = 0;
        stateBattle = 0;
    }

    /**
     * Get Factory Opponent.
     *
     * @return OpponentRandomFactory
     */
    public OpponentRandomFactory getFactory() {
        return factory;
    }

    /**
     * Get shift list.
     *
     * @return shiftList
     */
    public ArrayList<Character> getOrderOfPlayers() {
        return orderOfPlayers;
    }

    /**
     * Set next Player.
     *
     * @param isNextPlayer new next player
     */
    public void setIsNextPlayer(Character isNextPlayer) {
        this.isNextPlayer = isNextPlayer;
    }

    /**
     * Get next player.
     *
     * @return next player
     */
    public Character getIsNextPlayer() {
        return isNextPlayer;
    }

    /**
     * Get Turn.
     *
     * @return actual turn
     */
    private int getTurn() {
        return turn;
    }

    /**
     * Set Turn. Update current shift.
     *
     * @param turn new turn
     */
    private void setTurn(int turn) {
        this.turn = turn;
    }

    /**
     * Set actual player.
     *
     * @param isPlaying new actual player
     */
    private void setIsPlaying(Character isPlaying) {
        this.isPlaying = isPlaying;
    }

    /**
     * Get actual player.
     *
     * @return actual player
     */
    public Character getIsPlaying() {
        return isPlaying;
    }

    /**
     * creates a new hero of the specified type.
     *
     * @param rank define rank
     * @param type define heroType
     * @return new Hero
     */
    public Character createHero(int rank, HeroType type) {
        IHero hero;
        hero = type.equals(HeroType.MARCOS) ? new Marcos(rank, type) : new Luis(rank, type);
        addWithinList(hero);
        return hero;
    }

    /**
     * Add Character within trun list.
     *
     * @param c Character added
     */
    public void addWithinList(Character c) {
        orderOfPlayers.add(c);
        nextPlayer();
        actualPlayer();
    }

    /**
     * insert a seed in the variable "random" in order to determine
     * a particular value.
     *
     * @param seed class random seed
     */
    public void factoryPlantSeed(int seed) {
        factory.plantSeed(seed);
    }

    /**
     * a new enemy is created in the game of a specified rank.
     * It is added to the shift list.
     *
     * @param rank define rank
     * @return new Opponent object
     */
    public IOpponent addEnemies(int rank) {
        OpponentRandomFactory f = getFactory();
        IOpponent opponent = f.createOpponent(rank);
        addWithinList(opponent);
        return opponent;
    }

    /**
     * Chest object is created to store the items during the game.
     *
     * @return Chest object
     */
    public Chest addChest() {
        sharedChest = new Chest();
        return sharedChest;
    }

    /**
     * The same quantity of the items available in itemType is added.
     *
     * @param chest specific chest
     * @param n     value initial
     */
    public void fillChestInitial(int n) {
        sharedChest.initial(n);
    }

    /**
     * An item is obtained from a certain Chest.
     *
     * @param chest specific chest
     * @return item of the chest
     */
    public  Hashtable<ItemsType, Integer> getItem() {
        return sharedChest.getItemsChest();
    }

    /**
     * Perform the effect of an item on a hero.
     *
     * @param chest specific chest
     * @param item  select item
     * @param hero  select hero
     */
    public void spendItem(IItems item, IHero hero) {
        sharedChest.spend(item, hero);

    }

    /**
     * creates a new item object based on the current
     * ones available in ItemType.
     *
     * @param item specific item
     * @return new item
     */
    public IItems createItem(ItemsType item) {
        if (item.equals(ItemsType.RED_MUSHROOM)) {
            return new RedMushroom();
        }
        return new HoneySyrup();
    }

    /**
     * an item is added to the inventory of a chest.
     *
     * @param chest specific chest
     * @param item  select item
     */
    public void addItem(IItems item) {
        sharedChest.add(item);
    }


    /**
     * implements the rotating shifts of the game system. set current player
     * considering rotating rounds
     */
    public void actualPlayer() {
        if(turn == 0){
            setIsPlaying(orderOfPlayers.get(0));
        }else {
            setIsPlaying(getIsNextPlayer());
        }
    }

    /**
     * Set the next current player considering rotating rounds.
     */
    public void nextPlayer() {
        setIsNextPlayer(orderOfPlayers.get((getTurn() + 1) % orderOfPlayers.size()));
    }

    /**
     * Sets the logic for the end of a shift. Player attributes
     * and current turn are updated.
     */
    public void finishTurn() {
        setTurn(getTurn() + 1);
        actualPlayer();
        nextPlayer();
    }

    /**
     * Checks if a certain object exists in the list.
     *
     * @param c object searched.
     * @return true if it contains it
     */
    public boolean existCharacter(Character c) {
        return getOrderOfPlayers().contains(c);
    }

    /**
     * if the character us KO, his fight points
     * are equal to 0. In that case the character
     * is eliminated from the playerList.
     */
    public void defeatedCharacter(Character c) {
        c.KO();
        if (c.getHitPoints() == 0) {
            getOrderOfPlayers().remove(c);
            checkWinner();
        }
    }

    /**
     * Updates the value of the winner attribute.
     */
    public void checkWinner() {
        setStateBattle(winner());
    }

    /**
     * Compare the type of Character object with a specific type.
     *
     * @param c     Character object
     * @param hero1 typeHero
     * @return true if they are of the same type
     */
    public boolean compareType(Character c, HeroType hero1) {
        return c.getType().equals(hero1);

    }

    /**
     * Determine game status by reviewing the turn list. State 0 is maintained when
     * the game is active. 1 for a win. -1 for a loss.
     *
     * @return int game status
     */
    public int winner() {
        int a = 0;
        ListIterator<Character> n = getOrderOfPlayers().listIterator();
        while (n.hasNext()) {
            Character m = n.next();
            if (compareType(m, HeroType.MARCOS) || compareType(m, HeroType.LUIS)) a++;
        }
        if (a == getOrderOfPlayers().size()) {
            return 1;
        }
        return a == 0 ? -1 : 0;
    }

    /**
     * Get the game state variable.
     *
     * @return integer stateBattle.
     */
    public int getStateBattle() {
        return stateBattle;
    }

    /**
     * Set the game state variable
     *
     * @param stateBattle new stateBattle
     */
    public void setStateBattle(int stateBattle) {
        this.stateBattle = stateBattle;
    }

    /**
     * Auxiliary method for the development stage. A 100 degree knife
     * appears and pierces the throat of a selected character. The
     * character is instantly killed and out of the battle.
     *
     * @param c convicted character
     */
    public void knifeInWindpipe(Character c) {
        c.setHealthPoint(0);
        defeatedCharacter(c);
        checkWinner();
    }
}
